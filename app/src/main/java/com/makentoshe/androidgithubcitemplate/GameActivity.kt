package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var states: List<State> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        backpack.setOnClickListener {
            val intent: Intent = Intent(this, BackpackActivity::class.java)
            startActivity(intent)
        }

        equipment.setOnClickListener {
            val intent: Intent = Intent(this, EquipmentActivity::class.java)
            startActivity(intent)
        }

        states = readData(applicationContext)
        Log.d("state", states[0].msg)
        mainText.setTextAutoTyping(states[0].getText())
        mainText.setOnClickListener {
            Log.d("ANIMATION", mainText.text.toString())
            //mainText.text = states[0].msg
            if (mainText.isRunning()){
                mainText.typingSpeed = -1000000000
                //mainText.text = states[0].msg
            }
            else{
                mainText.typingSpeed = 75
                mainText.setTextAutoTyping(states[0].getText())
            }
        }

        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = Game(1)
        //Log.d("CUR GAMES", gameDao.getAll().size.toString())
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.chest1, typeOfItem = "chest"))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.helmet1, typeOfItem = "helmet"))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.legs1, typeOfItem = "boots"))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.uplegs1, typeOfItem = "legs"))!!
        gameDao.insertAll(game)

        healthV.text = "${game.player.hp}/${game.player.maxHp}"
        manaV.text = "${game.player.mana}/${game.player.maxMana}"
        expV.text = "${game.player.exp}/${game.player.maxExp}"
    }

    override fun onBackPressed() {

    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = gameDao.loadById(1)
        healthV.text = "${game.player.hp}/${game.player.maxHp}"
        manaV.text = "${game.player.mana}/${game.player.maxMana}"
        expV.text = "${game.player.exp}/${game.player.maxExp}"
    }

    override fun onPause() {
        super.onPause()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}
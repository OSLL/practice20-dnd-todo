package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var states: List<State> = emptyList()
    var curState: Int = 0

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

        states = readData(applicationContext, "data.json")
        Log.d("state", states[0].msg)
        mainText.setTextAutoTyping(states[curState].getText())
        mainText.setOnClickListener {
            Log.d("ANIMATION", mainText.text.toString())
            //mainText.text = states[0].msg
            if (mainText.isRunning()){
                mainText.typingSpeed = -1000000000
                //mainText.text = states[0].msg
            }
            else{
                if (!states[curState].isActive()){
                    /*if (states[curState].monster)
                        fightMonster(states[curState].getMonster())
                    if (states[curState].itemDrop)

                       PickUpItem(states[curState].getItem())
                    */
                    if (states[curState].itemDrop){
                        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
                        val game: Game = gameDao.loadById(1)
                        game.player.backpack!!.items  = game.player.backpack!!.items.plus(Item(drawableId = R.drawable.chest2, typeOfItem = "chest", armor = 2))
                        gameDao.insertAll(game)
                    }
                    curState++
                }
                Log.d("curState", curState.toString() + states.size.toString())
                if (!tryToWin()) {
                    Log.d("WHAT", "HERE???!!!")
                    mainText.typingSpeed = 75
                    mainText.setTextAutoTyping(states[curState].getText())
                }
            }
        }

        //Log.d("CUR GAMES", gameDao.getAll().size.toString())

        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = Game(1)
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.chest1, typeOfItem = "chest", armor = 2))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.helmet1, typeOfItem = "helmet", armor = 1))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.legs1, typeOfItem = "boots", armor = 1))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.uplegs1, typeOfItem = "legs", armor = 2))!!
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
        Log.d("ATTACK:", game.player.attack.toString())
        Log.d("Armor:", game.player.armor.toString())
    }

    override fun onPause() {
        super.onPause()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    private fun tryToWin() : Boolean {
        Log.d("WIN", "trying...")
        if (curState < states.size) return false
        Log.d("WIN", "WON!!!!")
        val intent: Intent = Intent(this, WinActivity::class.java)
        finish()
        startActivity(intent)
        return true
    }
}
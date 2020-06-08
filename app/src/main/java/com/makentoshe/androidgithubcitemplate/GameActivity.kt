package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var MAX_HEALTH: Int = 100
    var MAX_EXP: Int = 50
    var MAX_MANA: Int = 400

    var mana: Int = 0
    var health: Int = 100
    var exp: Int = 0

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

        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = Game(1)
        //Log.d("CUR GAMES", gameDao.getAll().size.toString())
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.chest1))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.helmet1))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.legs1))!!
        game.player.backpack?.items = game.player.backpack?.items?.plus(Item(drawableId = R.drawable.uplegs1))!!
        gameDao.insertAll(game)

        healthV.text = "$health/$MAX_HEALTH"
        manaV.text = "$mana/$MAX_MANA"
        expV.text = "$exp/$MAX_EXP"
    }

    override fun onBackPressed() {

    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onPause() {
        super.onPause()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}
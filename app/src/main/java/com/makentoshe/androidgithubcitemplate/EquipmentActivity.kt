package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_equipment.*

class EquipmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)

        to_gameB.setOnClickListener {
            onBackPressed()
        }

        to_backpackB.setOnClickListener {
            val intent: Intent = Intent(this, BackpackActivity::class.java)
            finish()
            startActivity(intent)
        }

        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = gameDao.loadById(1)

        for (i in game.player.equipedItems){
            when (i.typeOfItem){
                "helmet" -> helmet.setImageResource(i.drawableId)
                "chest" -> chest.setImageResource(i.drawableId)
                "legs" -> ulegs.setImageResource(i.drawableId)
                "boots" -> dlegs.setImageResource(i.drawableId)
            }
        }
    }
}
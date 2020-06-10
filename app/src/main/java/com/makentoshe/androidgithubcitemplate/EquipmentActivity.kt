package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_equipment.*

class EquipmentActivity : AppCompatActivity() {
    var lastPressed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

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
                "helmet" -> {
                    helmet.setImageResource(i.drawableId)
                    helmet.setOnClickListener {
                        EquipDialog.Factory().show(supportFragmentManager)
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                        lastPressed = "helmet"
                    }
                }
                "chest" -> {
                    chest.setImageResource(i.drawableId)
                    chest.setOnClickListener {
                        EquipDialog.Factory().show(supportFragmentManager)
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                        lastPressed = "chest"
                    }
                }
                "legs" -> {
                    ulegs.setImageResource(i.drawableId)
                    ulegs.setOnClickListener {
                        EquipDialog.Factory().show(supportFragmentManager)
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                        lastPressed = "legs"
                    }
                }
                "boots" -> {
                    dlegs.setImageResource(i.drawableId)
                    dlegs.setOnClickListener {
                        EquipDialog.Factory().show(supportFragmentManager)
                        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                        lastPressed = "boots"
                    }
                }
            }
        }

        hpTV.text = "Armor:${game.player.armor}"
        manaTV.text = "Attack:${game.player.attack}"
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2){
            val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
            val game: Game = gameDao.loadById(1)

            Log.d("DIALOG DEBUG", "pressed on $lastPressed")

            when (lastPressed){
                "helmet" -> {
                    helmet.setImageResource(R.drawable.empty)
                    helmet.setOnClickListener {

                    }

                }
                "chest" -> {
                    chest.setImageResource(R.drawable.empty)
                    chest.setOnClickListener {

                    }
                }
                "legs" -> {
                    ulegs.setImageResource(R.drawable.empty)
                    ulegs.setOnClickListener {

                    }
                }
                "boots" -> {
                    dlegs.setImageResource(R.drawable.empty)
                    dlegs.setOnClickListener {

                    }
                }
            }

            var ind: Int = 0;
            for (i in game.player.equipedItems.indices){
                if (game.player.equipedItems[i].typeOfItem == lastPressed){
                    ind = i
                    break
                }
            }
            val res: MutableList<Item> = game.player.equipedItems.toMutableList()
            val item: Item = res.removeAt(ind)
            game.player.armor = game.player.armor?.minus(item.armor)
            game.player.attack = game.player.attack?.minus(item.attack)

            game.player.backpack?.items = game.player.backpack?.items!!.plus(item)

            game.player.equipedItems = res.toList()

            gameDao.insertAll(game)

            hpTV.text = "Armor:${game.player.armor}"
            manaTV.text = "Attack:${game.player.attack}"
        }
    }
}
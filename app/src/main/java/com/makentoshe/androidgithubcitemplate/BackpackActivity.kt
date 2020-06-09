package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_backpack.*

class BackpackActivity : AppCompatActivity() {
    private var itemViews: List<ImageView> = emptyList()
    private var lastPressed: Int = 0

    fun addItems(){
        itemViews = itemViews.plus(item1)
        itemViews = itemViews.plus(item2)
        itemViews = itemViews.plus(item3)
        itemViews = itemViews.plus(item4)
        itemViews = itemViews.plus(item5)
        itemViews = itemViews.plus(item6)
        itemViews = itemViews.plus(item7)
        itemViews = itemViews.plus(item8)
        itemViews = itemViews.plus(item9)
        itemViews = itemViews.plus(item10)
        itemViews = itemViews.plus(item11)
        itemViews = itemViews.plus(item12)
        itemViews = itemViews.plus(item13)
        itemViews = itemViews.plus(item14)
        itemViews = itemViews.plus(item15)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backpack)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        Log.d("id", R.layout.dialog_equip.toString())


        to_game.setOnClickListener {
            super.onBackPressed()
        }

        to_equipment.setOnClickListener {
            val intent: Intent = Intent(this, EquipmentActivity::class.java)
            finish()
            startActivity(intent)
        }

        /*
        item1.setOnClickListener {
            EquipDialog.Factory().show(supportFragmentManager)
            //val eqDialog: EqiupDialog = EqiupDialog()
            //val manager = supportFragmentManager
            //eqDialog.show(manager, "myDialog")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
         */

        addItems()
        //itemViews = itemViews.plus(item1)

        val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
        val game: Game = gameDao.loadById(1)
        if (game == null) Log.d("GG", "null player(")
        Log.d("GGS", game.player.backpack?.items!!.lastIndex.toString())
        for (i in itemViews.indices){
            if (game.player.backpack?.items!!.lastIndex < i) break

            itemViews[i].setImageResource(game.player.backpack?.items!![i].drawableId)
            itemViews[i].setTag(game.player.backpack?.items!![i].drawableId)

            itemViews[i].setOnClickListener {
                EquipDialog.Factory().show(supportFragmentManager)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                lastPressed = i
            }
        }

        /*
        for (i in itemViews.indices){
            itemViews[i].setOnClickListener {
                EquipDialog.Factory().show(supportFragmentManager)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                lastPressed = i
            }
        }
         */
    }

    override fun onResume() {
        super.onResume()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.setOnSystemUiVisibilityChangeListener {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    override fun onPause() {
        super.onPause()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.setOnSystemUiVisibilityChangeListener {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            val gameDao = AppDatabase.getDatabase(applicationContext).gameDao()
            val game: Game = gameDao.loadById(1)

            if (game.player.backpack?.items!!.lastIndex < lastPressed)
                return

            Log.d("DIALOG DEBUG", "pressed on item$lastPressed")
            val res: MutableList<Item> = game.player.backpack?.items!!.toMutableList()
            // TODO(unequip item if we can)
            val item: Item = res.removeAt(lastPressed)
            game.player.armor = game.player.armor?.plus(item.armor)
            game.player.attack = game.player.attack?.plus(item.attack)

            game.player.equipedItems = game.player.equipedItems.plus(item)

            game.player.backpack?.items = res.toList()

            itemViews[game.player.backpack?.items!!.size].setImageResource(R.drawable.empty)
            itemViews[game.player.backpack?.items!!.size].setOnClickListener {

            }
            for (i in itemViews.indices){
                if (game.player.backpack?.items!!.lastIndex < i) break

                itemViews[i].setImageResource(game.player.backpack?.items!![i].drawableId)
                itemViews[i].setTag(game.player.backpack?.items!![i].drawableId)
            }
            gameDao.insertAll(game)
        }
    }
}
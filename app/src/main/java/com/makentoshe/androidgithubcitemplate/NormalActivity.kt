package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_normal.*

class NormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pr : Int = 1
        var prolog = Array<String>(4, {i : Int -> i.toString()})
        prolog[0] = "Однажды, в одном городе появился странник в плаще. Он был похож на обычного крестьянина, но аура у него была, как у солдата."
        prolog[1] = "Он пришел в бар, где заказал крепкое пиво и начал расспрашивать про замок. Он сказал, что он искатель приключений, а также сказал, что слышал про здешних монстров в замке."
        prolog[2] = "Странник сказал, что он победит монстров, но не просто так. Горожане предложили ему стать королем здешнего королевства, если он победит короля монстров."
        prolog[3] = "Странник согласился, после чего взял нужные предметы и отправился в замок"
        var monster = Array<String>(5, {i : Int -> i.toString()})
        monster[0] = ""
        monster[1] = ""
        monster[2] = ""
        monster[3] = ""
        monster[4] = ""
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_normal)

        text.text = prolog[0]

        text.setOnClickListener {
            if (pr < 4) {
                text.text = prolog[pr]
                pr++
            }
        }

        exit.setOnClickListener {
            Log.d("tag", "End")
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        backpack.setOnClickListener {
            Log.d("tag", "Equipment")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        equipment.setOnClickListener {
            Log.d("tag", "Equipment")
            val myIntent = Intent(this, Equipment::class.java)
            startActivity(myIntent)
        }
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }
}
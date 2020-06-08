package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_equipment.*
import kotlinx.android.synthetic.main.activity_normal.*
import kotlinx.android.synthetic.main.activity_normal.backpack

class Equipment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_equipment)

        exit_e.setOnClickListener {
            Log.d("tag", "Game")
            val myIntent = Intent(this, NormalActivity::class.java)
            startActivity(myIntent)
        }

        backpack.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        hood.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        armor.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        pants.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        boots.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        right_arm.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        left_arm.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        magic_1.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        magic_2.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        magic_3.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
            startActivity(myIntent)
        }

        magic_4.setOnClickListener {
            Log.d("tag", "Backpack")
            val myIntent = Intent(this, BackPackGame::class.java)
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
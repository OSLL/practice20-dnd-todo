package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_normal.*

class NormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_normal)
        exit.setOnClickListener {
            Log.d("tag", "End")
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
        equipment.setOnClickListener {
            Log.d("tag", "Equipment")
            val myIntent = Intent(this, Equipment::class.java)
            startActivity(myIntent)
        }
    }
}
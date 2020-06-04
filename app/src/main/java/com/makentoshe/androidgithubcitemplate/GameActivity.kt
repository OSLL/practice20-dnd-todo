package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        backpack.setOnClickListener {
            val intent: Intent = Intent(this, BackpackActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {

    }
}
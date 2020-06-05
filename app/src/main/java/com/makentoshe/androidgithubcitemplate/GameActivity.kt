package com.makentoshe.androidgithubcitemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
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
    }
}
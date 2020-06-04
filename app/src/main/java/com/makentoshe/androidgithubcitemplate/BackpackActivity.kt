package com.makentoshe.androidgithubcitemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_backpack.*

class BackpackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backpack)

        Log.d("id", R.layout.dialog_equip.toString())
        Log.d("id", R.id.yes.toString())
        Log.d("id", R.id.no.toString())


        back.setOnClickListener {
            super.onBackPressed()
        }

        item1.setOnClickListener {
            val eqDialog: EqiupDialog = EqiupDialog()
            val manager = supportFragmentManager
            eqDialog.show(manager, "myDialog")
        }
    }
}
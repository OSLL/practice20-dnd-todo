package com.makentoshe.androidgithubcitemplate

import android.R.id
import android.app.Dialog
import android.os.Bundle
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
//import kotlinx.android.synthetic.main.dialog_equip.*


class EqiupDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_equip, container, false)
        val yes: Button = v.findViewById(R.id.yes)
        val no: Button = v.findViewById(R.id.no)


        yes.setOnClickListener {
            Log.d("PRESSED", "yes pressed in dialog")
            dialog?.dismiss()
        }
        no.setOnClickListener {
            Log.d("PRESSED", "no pressed in dialog")
            dialog?.dismiss()
        }

        return v // normaldi rabotaet
//        return inflater.inflate(R.layout.dialog_equip, container, false) //ne norm ne builditsa
        //return super.onCreateView(inflater.inflate(R.layout.dialog_eqiup, container, false), container, savedInstanceState)
    }
}
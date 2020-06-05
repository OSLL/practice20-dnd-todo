package com.makentoshe.androidgithubcitemplate

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class EquipDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.dialog_equip)
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
        builder.setPositiveButton("Equip") { dialog, _ ->
            onPositiveClick(dialog as AlertDialog)
            dismiss()
        }
        return builder.create()
    }

    private fun onPositiveClick(dialog: AlertDialog) {
        val intent = Intent().putExtra("click", 1)
        (requireActivity() as BackpackActivity).onActivityResult(1, 1, intent)
    }

    class Factory {

        fun show(parentFragmentManager: FragmentManager): EquipDialog {
            val fragment = EquipDialog()
            fragment.show(parentFragmentManager, EquipDialog::class.java.simpleName)
            return fragment
        }
    }
}
package com.payments.b2b.app_base.utils_base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.payments.b2b.R

class CustomDialog(val context: Context) {

    fun createAlert(binding: ViewDataBinding): Pair<View, AlertDialog> {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setView(binding.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
        return Pair(binding.root, alertDialog)
    }

    fun createBottomSheet(binding: ViewDataBinding): Pair<View, BottomSheetDialog>{
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(binding.root)
        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.show()
        return Pair(binding.root, bottomSheetDialog)
    }
}
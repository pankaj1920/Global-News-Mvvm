package com.payments.b2b.app_base.utils_base

import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackbarMessage {
    fun showNetworkMessage(view: View, codeSnippet: CodeSnippet) {
        val snackBar = Snackbar.make(view, "No Network found!", Snackbar.LENGTH_LONG)
        snackBar.setActionTextColor(Color.RED)
        snackBar.setTextColor(Color.WHITE)
        snackBar.setAction("Settings") { codeSnippet.showNetworkSettings() }
        snackBar.show()
    }

}
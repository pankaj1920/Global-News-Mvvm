package com.payments.b2b.app_base.utils_base

import android.content.Context
import android.content.Intent
import com.payments.b2b.R

object BaseUtils {
    fun shareOnAllApps(context: Context, body: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        val sub = "Issue in " + context.getString(R.string.app_name)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, sub)
        intent.putExtra(Intent.EXTRA_TEXT, body)
        context.startActivity(Intent.createChooser(intent, "Share using"))
    }
}
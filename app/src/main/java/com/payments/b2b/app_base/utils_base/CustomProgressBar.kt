package com.payments.b2b.app_base.utils_base

import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.applaunch.talent.utils.extensions.color
import com.payments.b2b.R
import com.payments.b2b.databinding.LoaderBinding

class CustomProgressBar {

    var dialog: Dialog? = null

    fun show(context: Context): Dialog {
        return show(context, null)
    }

    fun show(context: Context, title: CharSequence?): Dialog {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val loaderBinding: LoaderBinding = DataBindingUtil
            .inflate(inflator, R.layout.loader, null, false);


        if (title != null) {
//            view.cp_title.visibility = View.VISIBLE
//            view.cp_title.text = title
        } else
//            view.cp_title.visibility = View.GONE
            loaderBinding.cpBgView.setBackgroundColor(context.resources.color(R.color.cpBgView)) //Background Color
        loaderBinding.cpCardview.setCardBackgroundColor(context.resources.color(R.color.cpCardview)) //Box Color
//        setColorFilter(view.cp_pbar.indeterminateDrawable,
//            ResourcesCompat.getColor(context.resources, R.color.light_gray, null)) //Progress Bar Color
        loaderBinding.cpTitle.setTextColor(Color.BLACK) //Text Color

        dialog = Dialog(context, R.style.CustomProgressBarTheme)
        dialog!!.setContentView(loaderBinding.root)
        dialog!!.show()

        return dialog!!
    }

    fun setColorFilter(drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }
}
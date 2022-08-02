package com.payments.b2b.global_news.binding_adapter

import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.payments.b2b.app_base.utils_base.Print

@BindingAdapter("isMobile")
fun isMobile(view: EditText, value: String?) {
    Print.log("value $value")
    if (value.isNullOrEmpty() || value.length != 10) {
        view.setError("Enter mobile number")
    }
}



package com.payments.b2b.app_base.utils_base

import com.payments.b2b.BuildConfig

object Print {
    fun log(message:String){
        if (BuildConfig.DEBUG){
            println("##################################")
            println("LOG : $message")
        }

    }
}
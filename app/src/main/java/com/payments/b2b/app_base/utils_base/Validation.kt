package com.payments.b2b.app_base.utils_base

fun String.isNN(txt: String): Boolean {
    return txt.isNotEmpty()
}

fun String.checkStatusCode(): Boolean {
    return this.equals("TXN", ignoreCase = true)
}

fun getApiErrorMessage(statusCode:String,message:String):String{
    return "StatusCode : $statusCode \nMessage : $message"
}
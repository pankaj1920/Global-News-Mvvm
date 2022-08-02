package com.payments.b2b.global_news.model.dto

data class LoginData(
    val id:String,
    val last_login:String,
    val first_name:String,
    val last_name:String,
    val email:String,
    val mobile:String,
    val otp:String,
    val address:String,
    val created_at:String,
    val updated_at:String,
)

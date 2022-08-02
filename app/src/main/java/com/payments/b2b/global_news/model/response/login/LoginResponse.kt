package com.payments.b2b.global_news.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.payments.b2b.app_base.model_base.BaseResponse
import com.payments.b2b.global_news.model.dto.LoginData
import java.util.*

data class LoginResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("data")
    val data: LoginData,
    /*@SerializedName("error_data")
    val error_data:String*/
):BaseResponse()

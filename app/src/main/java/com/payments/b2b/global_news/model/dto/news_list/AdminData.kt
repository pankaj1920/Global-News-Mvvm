package com.payments.b2b.global_news.model.dto.news_list

import com.google.gson.annotations.SerializedName

data class AdminData(
    @SerializedName("id")
    val id: String,

    @SerializedName("first_name")
    val first_name: String,

    @SerializedName("last_name")
    val last_name: String,

    @SerializedName("email")
    val email: String,


    )
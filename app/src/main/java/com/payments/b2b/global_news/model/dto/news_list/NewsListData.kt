package com.payments.b2b.global_news.model.dto.news_list

import com.google.gson.annotations.SerializedName

data class NewsListData(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("photo_url")
    val photo_url: String,

    @SerializedName("admin")
    val admin: AdminData,

    @SerializedName("categories")
    val categories: CategoriesData,


    @SerializedName("created_at")
    val created_at: String,


    )
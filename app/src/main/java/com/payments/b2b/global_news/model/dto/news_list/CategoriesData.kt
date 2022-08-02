package com.payments.b2b.global_news.model.dto.news_list

import com.google.gson.annotations.SerializedName

data class CategoriesData(
    @SerializedName("id")
    val id: String,

    @SerializedName("category")
    val category: String,
)
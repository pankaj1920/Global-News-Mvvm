package com.payments.b2b.global_news.model.response.news_list

import com.google.gson.annotations.SerializedName
import com.payments.b2b.app_base.model_base.BaseResponse
import com.payments.b2b.global_news.model.dto.news_list.NewsListData

data class NewsListResponse(
    @SerializedName("data")
    val data: ArrayList<NewsListData>,
) : BaseResponse()
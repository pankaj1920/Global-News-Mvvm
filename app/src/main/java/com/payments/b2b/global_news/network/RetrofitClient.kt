package com.payments.b2b.global_news.network

import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.network.BaseRetrofitClient
import com.payments.b2b.app_base.network.NetworkUtils


class RetrofitClient(listener: BaseIRepoListener?) : BaseRetrofitClient(listener) {
    fun getApiService(): ApiService = provideRetrofit(provideOkHttpClient(), NetworkUtils.BASE_URL)
        .create(ApiService::class.java)
}

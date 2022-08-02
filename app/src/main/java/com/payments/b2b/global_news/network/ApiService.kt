package com.payments.b2b.global_news.network

import com.payments.b2b.global_news.model.request.login.LoginRequest
import com.payments.b2b.global_news.model.request.register.RegisterRequest
import com.payments.b2b.global_news.model.response.login.LoginResponse
import com.payments.b2b.global_news.model.response.news_list.NewsListResponse
import com.payments.b2b.global_news.model.response.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("admin/register")
    suspend fun registerAdmin(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("admin/login")
    suspend fun loginAdmin(@Body request: LoginRequest): Response<LoginResponse>

    @GET("admin/news/list")
    suspend fun getNewsList(): Response<NewsListResponse>

}

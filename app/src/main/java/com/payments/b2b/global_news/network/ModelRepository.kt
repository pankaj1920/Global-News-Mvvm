package com.payments.b2b.global_news.network


import com.base.app.model.State
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.network.NetworkBoundRepository
import com.payments.b2b.global_news.model.request.login.LoginRequest
import com.payments.b2b.global_news.model.request.register.RegisterRequest
import com.payments.b2b.global_news.model.response.login.LoginResponse
import com.payments.b2b.global_news.model.response.news_list.NewsListResponse
import com.payments.b2b.global_news.model.response.register.RegisterResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ModelRepository(private val iRepositoryListener: BaseIRepoListener?) {
    private val apiService = RetrofitClient(iRepositoryListener)

    fun adminRegister(request: RegisterRequest): Flow<State<RegisterResponse>> {
        return object : NetworkBoundRepository<RegisterResponse>(iRepositoryListener) {
            override suspend fun fetchData(): Response<RegisterResponse> =
                apiService.getApiService().registerAdmin(request)
        }.asFlow()
    }

    fun loginAdmin(request: LoginRequest): Flow<State<LoginResponse>> {
        return object : NetworkBoundRepository<LoginResponse>(iRepositoryListener) {
            override suspend fun fetchData(): Response<LoginResponse> =
                apiService.getApiService().loginAdmin(request)
        }.asFlow()
    }

    fun newList(): Flow<State<NewsListResponse>> {
        return object : NetworkBoundRepository<NewsListResponse>(iRepositoryListener) {
            override suspend fun fetchData(): Response<NewsListResponse> =
                apiService.getApiService().getNewsList()
        }.asFlow()


    }
}

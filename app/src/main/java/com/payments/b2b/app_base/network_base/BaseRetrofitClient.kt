package com.payments.b2b.app_base.network

import com.payments.b2b.BuildConfig
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.BaseConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseRetrofitClient(var iRepositoryListener: BaseIRepoListener?) {

    protected fun provideRetrofit(
        okHttpClient: OkHttpClient,
        networkUtils: NetworkUtils
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseMapping.getBaseUrl(networkUtils))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)

            .build()
    }

    //Create OkHttpClient
    protected fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClientBuilder = OkHttpClient.Builder()

        okHttpClientBuilder.apply {
            connectTimeout(40, TimeUnit.SECONDS)
            readTimeout(40, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG)
                addInterceptor(loggingInterceptor)
        }
        okHttpClientBuilder.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header(BaseConstants.Header.AUTHORIZATION, "Token 684d95419c7ce5768b937abf6b71c36df7021290")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }
        return okHttpClientBuilder.build()
    }
}
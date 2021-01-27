package com.example.adminglobalnews.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {

    private final static String BASE_URL = "http://192.168.43.133:8000/api/";
    private static Retrofit retrofitEndPoint;

    public static Retrofit getBaseClient() {
        if (retrofitEndPoint == null) {
            retrofitEndPoint = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofitEndPoint;
    }
}

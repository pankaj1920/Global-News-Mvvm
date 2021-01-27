package com.example.adminglobalnews.network;

import com.example.adminglobalnews.model.login.MobileLoginModel;
import com.example.adminglobalnews.model.register.RegisterModel;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NewsApi {

    @FormUrlEncoded
    @POST("admin_register")
    Single<RegisterModel> register(
            @Field("name") String name,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("password") String password,
            @Field("address") String address
    );

    @FormUrlEncoded
    @POST("admin_mobile_login")
    Single<MobileLoginModel> mobileLogin(
            @Field("mobile") String mobile
    );


}

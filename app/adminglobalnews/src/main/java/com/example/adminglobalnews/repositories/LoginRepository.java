package com.example.adminglobalnews.repositories;

import androidx.lifecycle.LiveData;

import com.example.adminglobalnews.datasource.MobileLoginApiCall;
import com.example.adminglobalnews.model.login.MobileLoginModel;

public class LoginRepository {

    private MobileLoginApiCall mobileLoginApiCall;
    private static LoginRepository instance;

    public LoginRepository() {
        mobileLoginApiCall = MobileLoginApiCall.getInstance();
    }

    public static LoginRepository getInstance(){
        if (instance==null){
            instance = new LoginRepository();
        }
        return instance;
    }

    public LiveData<MobileLoginModel> getMobileLoginResponse(){
        return mobileLoginApiCall.getMobileLoginResponse();
    }

    public void mobileLogin(String mobile){
        mobileLoginApiCall.mobileLogin(mobile);
    }
}

package com.example.adminglobalnews.repositories;

import androidx.lifecycle.LiveData;

import com.example.adminglobalnews.datasource.RegisterApiCall;
import com.example.adminglobalnews.model.register.RegisterModel;

public class RegisterRepository {

    private RegisterApiCall registerApiCall;
    private static RegisterRepository instance;

    public static RegisterRepository getInstance() {
        if (instance == null) {
            instance = new RegisterRepository();
        }
        return instance;
    }

    public RegisterRepository() {
        registerApiCall = RegisterApiCall.getInstance();
    }

    public LiveData<RegisterModel> getRegisterResponse() {
        return registerApiCall.getRegisterResponse();
    }

    public void register(String name, String mobile, String email, String password, String address) {
        registerApiCall.register(name, mobile, email, password, address);
    }

    public void clearDisposable(){
        registerApiCall.clearDisposable();
    }
}

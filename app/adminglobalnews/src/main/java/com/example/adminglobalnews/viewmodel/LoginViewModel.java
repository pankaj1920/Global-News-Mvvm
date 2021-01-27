package com.example.adminglobalnews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.adminglobalnews.model.login.MobileLoginModel;
import com.example.adminglobalnews.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {

    private LoginRepository loginRepository;
    private static LoginViewModel instance;

    public LoginViewModel() {
        loginRepository = LoginRepository.getInstance();
    }

    public LiveData<MobileLoginModel> getMobileLoginResponse() {
        return loginRepository.getMobileLoginResponse();
    }

    public void mobileLogin(String mobile) {
        loginRepository.mobileLogin(mobile);
    }

}

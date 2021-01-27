package com.example.adminglobalnews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.adminglobalnews.model.register.RegisterModel;
import com.example.adminglobalnews.repositories.RegisterRepository;

public class RegisterViewModel extends ViewModel {

    private RegisterRepository registerRepository;
    private static RegisterViewModel instance;

    public RegisterViewModel() {
        registerRepository = RegisterRepository.getInstance();
    }

    public static RegisterViewModel getInstance() {
        if (instance == null) {
            instance = new RegisterViewModel();
        }
        return instance;
    }

    public LiveData<RegisterModel> getRegisterResponse() {
        return registerRepository.getRegisterResponse();
    }

    public void register(String name, String mobile, String email, String password, String address) {
        registerRepository.register(name, mobile, email, password, address);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        registerRepository.clearDisposable();
    }
}

package com.example.adminglobalnews.datasource;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.adminglobalnews.model.register.RegisterModel;
import com.example.adminglobalnews.network.BaseClient;
import com.example.adminglobalnews.network.NewsApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegisterApiCall {

    private MutableLiveData<RegisterModel> registerResponse;
    private CompositeDisposable disposable = new CompositeDisposable();
    private static RegisterApiCall instance;

    //Constructor
    public RegisterApiCall() {
        registerResponse = new MutableLiveData<>();
    }

    public static RegisterApiCall getInstance() {
        if (instance == null) {
            instance = new RegisterApiCall();
        }
        return instance;
    }

    public LiveData<RegisterModel> getRegisterResponse(){
        return registerResponse;
    }

    public void register(String name, String mobile, String email, String password, String address){
        NewsApi newsApi = BaseClient.getBaseClient().create(NewsApi.class);

        newsApi.register(name,mobile,email,password,address)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RegisterModel>() {
                    @Override
                    public void onSuccess(@NonNull RegisterModel registerModel) {
                        registerResponse.setValue(registerModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error", "onError: "+e.getMessage());
                    }
                });
    }

    public void clearDisposable() {
        disposable.clear();
    }

}

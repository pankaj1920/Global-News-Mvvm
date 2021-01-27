package com.example.adminglobalnews.datasource;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.adminglobalnews.model.login.MobileLoginModel;
import com.example.adminglobalnews.network.BaseClient;
import com.example.adminglobalnews.network.NewsApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MobileLoginApiCall {

    private MutableLiveData<MobileLoginModel> mobileLoginResponse;
    private CompositeDisposable disposable = new CompositeDisposable();
    private static MobileLoginApiCall instance;

    public MobileLoginApiCall() {
        mobileLoginResponse = new MutableLiveData<>();
    }

    public static MobileLoginApiCall getInstance() {
        if (instance == null) {
            instance = new MobileLoginApiCall();
        }
        return instance;
    }

    public LiveData<MobileLoginModel> getMobileLoginResponse(){
        return mobileLoginResponse;
    }

    public void mobileLogin(String number){
        NewsApi newsApi = BaseClient.getBaseClient().create(NewsApi.class);
        newsApi.mobileLogin(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<MobileLoginModel>() {
                    @Override
                    public void onSuccess(@NonNull MobileLoginModel mobileLoginModel) {
                        mobileLoginResponse.setValue(mobileLoginModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error", "onError: "+e.getMessage());
                    }
                });
    }
}

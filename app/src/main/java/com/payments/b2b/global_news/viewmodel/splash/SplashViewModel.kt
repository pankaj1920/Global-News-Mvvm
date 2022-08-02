package com.payments.b2b.global_news.viewmodel.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import com.payments.b2b.global_news.state.splash.SplashState
import com.payments.b2b.global_news.utils.Constants

class SplashViewModel : BaseViewModel<SplashState>() {

    private var splashState: SplashState = SplashState.Int
        set(value) {
            field = value
            publishState(splashState)
        }

    override fun onInitialized(bundle: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            splashState = SplashState.Navigate
        }, Constants.HandlerTime.splashTime)
    }
}
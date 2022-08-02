package com.payments.b2b.global_news.state.splash

sealed class SplashState {
    object Int : SplashState()
    object Navigate : SplashState()
}
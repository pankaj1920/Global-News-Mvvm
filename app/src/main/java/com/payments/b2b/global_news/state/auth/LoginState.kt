package com.payments.b2b.global_news.state.auth

import com.payments.b2b.global_news.model.response.login.LoginResponse

sealed class LoginState {
    object Init : LoginState()
    object NavigateToRegister : LoginState()
    object NavigateToForgotPassword : LoginState()
    data class NavigateToHome(val data: LoginResponse):LoginState()
}
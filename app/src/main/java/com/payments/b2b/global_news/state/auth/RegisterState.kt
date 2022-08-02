package com.payments.b2b.global_news.state.auth

sealed class RegisterState {
    object Init : RegisterState()
    object NavigateToLogin : RegisterState()
    data class SHOW_ERROR(var error:String) : RegisterState()
}

package com.payments.b2b.global_news.viewmodel.auth

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.base.app.model.State
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel

import com.payments.b2b.global_news.model.request.register.RegisterRequest
import com.payments.b2b.global_news.model.response.register.RegisterResponse
import com.payments.b2b.global_news.network.ModelRepository
import com.payments.b2b.global_news.state.auth.RegisterState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegisterViewModel : BaseViewModel<RegisterState>() {

    val data = RegisterRequest()

    private var state: RegisterState = RegisterState.Init
        set(value) {
            field = value
            publishState(state)
        }

    override fun onInitialized(bundle: Bundle?) {

    }

    fun registerAdmin( iRepositoryListener: BaseIRepoListener?) {
        viewModelScope.launch {
            Print.log("Register button Clicked")
            ModelRepository(iRepositoryListener).adminRegister(data).collect {
                when (it) {
                    is State.Success -> {
                        handleSuccess(it.data)
                    }
                    is State.Error -> {
                        Print.log("Register View Model ${it.message}")
                        state = RegisterState.SHOW_ERROR(it.message)

                    }
                    else -> {
                        Print.log("Something went Wrong")
                    }
                }
            }

        }
    }
    private fun handleSuccess(response: RegisterResponse) {
        response.message?.let { message -> Print.log(message) }
        if (response.data != null)
            state = RegisterState.NavigateToLogin
    }
}
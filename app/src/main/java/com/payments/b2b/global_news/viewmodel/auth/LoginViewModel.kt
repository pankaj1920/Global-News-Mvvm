package com.payments.b2b.global_news.viewmodel.auth

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.base.app.model.State
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.utils_base.checkStatusCode
import com.payments.b2b.app_base.utils_base.getApiErrorMessage
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import com.payments.b2b.global_news.model.request.login.LoginRequest
import com.payments.b2b.global_news.network.ModelRepository
import com.payments.b2b.global_news.state.auth.LoginState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel<LoginState>() {

    val loginRequestData = LoginRequest()

    private var state: LoginState = LoginState.Init
        set(value) {
            field = value
            publishState(state)
        }

    override fun onInitialized(bundle: Bundle?) {

    }

    fun login(baseIRepoListener: BaseIRepoListener) {
        if (isValid(baseIRepoListener)) {
            viewModelScope.launch {
                ModelRepository(baseIRepoListener).loginAdmin(loginRequestData).collect {
                    when (it) {
                        is State.Success -> {
                            if (it.data.statuscode!!.checkStatusCode()) {
                                state = LoginState.NavigateToHome(it.data)
                            } else {
                                it.data.message?.let { msg ->
                                    baseIRepoListener.showErrorMessage(
                                        getApiErrorMessage(it.data.statuscode, it.data.message)
                                    )
                                }
                            }


                        }
                        is State.Error -> {
                            Print.log("Login View Model ${it.message}")
                        }
                        is State.Loading -> {}
                    }
                }
            }

        }
    }

    fun isValid(listener: BaseIRepoListener): Boolean {
        if (loginRequestData.email.isEmpty()) {
            listener.showMessage("Enter Email")
            return false
        } else if (loginRequestData.password.isEmpty()) {
            listener.showMessage("Enter Password")
        }
        return true
    }

}
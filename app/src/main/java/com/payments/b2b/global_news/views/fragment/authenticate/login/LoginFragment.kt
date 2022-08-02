package com.payments.b2b.global_news.views.fragment.authenticate.login

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.payments.b2b.R
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.utils_base.navigateNew
import com.payments.b2b.app_base.utils_base.navigateTo
import com.payments.b2b.app_base.utils_base.showError
import com.payments.b2b.app_base.view_base.BaseFragment
import com.payments.b2b.databinding.FragmentLoginBinding
import com.payments.b2b.global_news.data_store.SessionConstants
import com.payments.b2b.global_news.model.response.login.LoginResponse
import com.payments.b2b.global_news.state.auth.LoginState
import com.payments.b2b.global_news.utils.Constants
import com.payments.b2b.global_news.viewmodel.auth.LoginViewModel
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_login

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                is LoginState.NavigateToHome -> {
                    saveUserData(it.data)
                    findNavController().navigateTo(R.id.action_loginFragment_to_homeFragment, null)
                }
                else -> {

                }
            }
        }
    }

    override fun onFragmentCreated() {
        mViewBinding.clickListener = this
        mViewBinding.viewModel = mViewModel


    }

    private fun saveUserData(data: LoginResponse) {
        Print.log("ID ${data.data.id} Name : ${data.data.first_name}")
        viewLifecycleOwner.lifecycleScope.launch {
            sessionManager.putPreference(SessionConstants.ADMIN_TOKEN, data.token)
            sessionManager.putPreference(SessionConstants.ADMIN_ID, data.data.id)
            sessionManager.putPreference(SessionConstants.ADMIN_FIRST_NAME, data.data.first_name)
            sessionManager.putPreference(SessionConstants.ADMIN_LAST_NAME, data.data.last_login)
            sessionManager.putPreference(SessionConstants.ADMIN_EMAIL, data.data.email)
            sessionManager.putPreference(SessionConstants.ADMIN_MOBILE, data.data.mobile)
            sessionManager.putPreference(SessionConstants.ADMIN_ADDRESS, data.data.address)
        }

    }

    fun onLoginClicked(view: View) {
        Print.log("Login Request : ${mViewModel.loginRequestData}")
        mViewModel.login(iRepositoryListener)
    }

    fun onSignupClicked(view: View) {
        findNavController().navigateTo(R.id.action_loginFragment_to_registerFragment, null)
    }

    override fun showErrorMessage(message: String) {
        showError(message)
    }
}
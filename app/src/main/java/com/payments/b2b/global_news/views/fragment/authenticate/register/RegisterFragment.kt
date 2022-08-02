package com.payments.b2b.global_news.views.fragment.authenticate.register

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.payments.b2b.R
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.utils_base.Toaster
import com.payments.b2b.app_base.view_base.BaseFragment
import com.payments.b2b.databinding.FragmentRegisterBinding
import com.payments.b2b.global_news.state.auth.RegisterState
import com.payments.b2b.global_news.viewmodel.auth.RegisterViewModel


class RegisterFragment :
    BaseFragment<RegisterViewModel, FragmentRegisterBinding>() {

    override val mViewModel: RegisterViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_register


    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                is RegisterState.NavigateToLogin -> {
                    findNavController().navigate(
                        R.id.action_registerFragment_to_loginFragment,
                        null
                    )
                }
                is RegisterState.SHOW_ERROR -> {
                    Toaster.show(requireContext(), it.error)
                }
            }
        }


    }

    override fun onFragmentCreated() {
        mViewBinding.clickListener = this
        mViewBinding.viewModel = mViewModel
    }

    fun onSubmitClicked(view: View) {
        Print.log(mViewModel.data.toString())
        mViewModel.registerAdmin(iRepositoryListener)
    }

}
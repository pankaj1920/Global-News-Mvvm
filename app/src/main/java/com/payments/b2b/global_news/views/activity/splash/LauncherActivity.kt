package com.payments.b2b.global_news.views.activity.splash


import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.payments.b2b.R
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.utils_base.navigateNew
import com.payments.b2b.app_base.utils_base.toastMessage
import com.payments.b2b.app_base.view_base.BaseActivity
import com.payments.b2b.databinding.ActivityLauncherBinding
import com.payments.b2b.global_news.data_store.SessionConstants
import com.payments.b2b.global_news.state.splash.SplashState
import com.payments.b2b.global_news.utils.Constants
import com.payments.b2b.global_news.viewmodel.splash.SplashViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LauncherActivity(override val layoutId: Int = R.layout.activity_launcher) :
    BaseActivity<SplashViewModel, ActivityLauncherBinding>() {

    var userFirstName = "";

    override val mViewModel: SplashViewModel by viewModels()
    override fun onInitialize() {
        lifecycleScope.launch {

            sessionManager.getPreference(SessionConstants.ADMIN_FIRST_NAME,"not found").collect {
                Print.log("First Name : ${it}")
                toastMessage(it)
            }
        }



    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                is SplashState.Navigate -> {
                    iRepositoryListener.hideLoader()
                    navigateNew(null, Constants.Activity.AuthActivity)
                }
                else -> {
                    Print.log("Something went wrong")
                }
            }
        }
    }



}
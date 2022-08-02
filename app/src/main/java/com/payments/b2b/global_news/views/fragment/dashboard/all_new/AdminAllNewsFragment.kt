package com.payments.b2b.global_news.views.fragment.dashboard.all_new

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.payments.b2b.R
import com.payments.b2b.app_base.utils_base.hide
import com.payments.b2b.app_base.utils_base.show
import com.payments.b2b.app_base.view_base.BaseFragment
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import com.payments.b2b.databinding.FragmentAdminAllNewsBinding
import com.payments.b2b.global_news.state.all_news.AllNewsState
import com.payments.b2b.global_news.viewmodel.all_news.AllNewViewModel
import com.payments.b2b.global_news.viewmodel.auth.LoginViewModel


class AdminAllNewsFragment : BaseFragment<AllNewViewModel, FragmentAdminAllNewsBinding>() {

    override val mViewModel: AllNewViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_admin_all_news

    override fun onFragmentCreated() {
        mViewModel.fetchNewsList(iRepositoryListener)

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                is AllNewsState.UpdateNewsList -> {
                    mViewBinding.rvNewsList.adapter = it.adapter
                }
                else -> {
                }
            }
        }
    }


}
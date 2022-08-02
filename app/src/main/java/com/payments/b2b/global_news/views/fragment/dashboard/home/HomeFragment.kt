package com.payments.b2b.global_news.views.fragment.dashboard.home

import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator
import com.payments.b2b.R
import com.payments.b2b.app_base.view_base.BaseFragment
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import com.payments.b2b.databinding.FragmentHomeBinding
import com.payments.b2b.global_news.adapter.tablayout.HomeTabAdapter
import com.payments.b2b.global_news.viewmodel.home.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val layoutId: Int = R.layout.fragment_home

    override val mViewModel: BaseViewModel<*> = HomeViewModel()


    override fun onFragmentCreated() {
        intHomeTab()
    }


    override fun subscribeObservers() {

    }

    private fun intHomeTab() {
        mViewBinding.tabHome.addTab(
            mViewBinding.tabHome.newTab().setText(getString(R.string.data_stat))
        )
        val homeTabAdapter = HomeTabAdapter(
            requireActivity().supportFragmentManager,
            lifecycle,
            3
        )
        mViewBinding.vpHome.adapter = homeTabAdapter

        TabLayoutMediator(mViewBinding.tabHome, mViewBinding.vpHome) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.data_stat)
                1 -> tab.text = getString(R.string.upload_item)
                2 -> tab.text = getString(R.string.all_data)
            }

        }.attach()
        mViewBinding.vpHome.isUserInputEnabled = false

    }
}
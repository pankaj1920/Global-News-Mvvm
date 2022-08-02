package com.payments.b2b.global_news.adapter.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.payments.b2b.global_news.views.fragment.dashboard.all_new.AdminAllNewsFragment
import com.payments.b2b.global_news.views.fragment.dashboard.data_stats.AdminDataStatsFragment
import com.payments.b2b.global_news.views.fragment.dashboard.upload_news.CreateNewsFragment

class HomeTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, val tabCount: Int) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return AdminDataStatsFragment()
            1 -> return CreateNewsFragment()
            2 -> return AdminAllNewsFragment()
            else -> Fragment()
        }
    }
}
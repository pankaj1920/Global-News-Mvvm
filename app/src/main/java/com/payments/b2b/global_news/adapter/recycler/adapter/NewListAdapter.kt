package com.payments.b2b.global_news.adapter.recycler.adapter

import android.view.ViewGroup
import com.payments.b2b.R
import com.payments.b2b.app_base.adapter_base.BaseRecyclerAdapter
import com.payments.b2b.databinding.InflateAdminNewsItemBinding
import com.payments.b2b.global_news.adapter.recycler.viewholder.NewListViewHolder
import com.payments.b2b.global_news.model.dto.news_list.NewsListData
import com.payments.b2b.global_news.model.response.news_list.NewsListResponse
import com.payments.b2b.global_news.viewmodel.all_news.AllNewViewModel

class NewListAdapter( list: MutableList<NewsListData>, var viewModel: AllNewViewModel) :
    BaseRecyclerAdapter<NewsListData, NewListViewHolder>(list) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewListViewHolder {
        return NewListViewHolder(
            inflateDataBinding(
                R.layout.inflate_admin_news_item,
                parent
            ) as InflateAdminNewsItemBinding, viewModel
        )
    }
}
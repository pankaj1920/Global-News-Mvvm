package com.payments.b2b.global_news.adapter.recycler.viewholder

import com.payments.b2b.app_base.adapter_base.BaseViewHolder
import com.payments.b2b.databinding.InflateAdminNewsItemBinding
import com.payments.b2b.global_news.model.dto.news_list.NewsListData
import com.payments.b2b.global_news.viewmodel.all_news.AllNewViewModel

class NewListViewHolder(var binding: InflateAdminNewsItemBinding, var viewModel: AllNewViewModel) :
    BaseViewHolder<NewsListData, InflateAdminNewsItemBinding>(binding) {

    override fun populateData(data: NewsListData) {
        binding.data = data
    }

}
package com.payments.b2b.global_news.state.all_news

import com.payments.b2b.global_news.adapter.recycler.adapter.NewListAdapter

sealed class AllNewsState{
    object Init:AllNewsState()
    data class UpdateNewsList(var adapter: NewListAdapter?):AllNewsState()
}

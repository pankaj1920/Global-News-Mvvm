package com.payments.b2b.global_news.viewmodel.all_news

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.base.app.model.State
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.Print
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import com.payments.b2b.global_news.adapter.recycler.adapter.NewListAdapter
import com.payments.b2b.global_news.model.dto.news_list.NewsListData
import com.payments.b2b.global_news.network.ModelRepository
import com.payments.b2b.global_news.state.all_news.AllNewsState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AllNewViewModel : BaseViewModel<AllNewsState>() {

    var newListAdapter: NewListAdapter? = null

    private var state: AllNewsState = AllNewsState.Init
        set(value) {
            field = value
            publishState(state)
        }

    override fun onInitialized(bundle: Bundle?) {

    }

    fun fetchNewsList(baseIRepoListener: BaseIRepoListener) {
        viewModelScope.launch {
            ModelRepository(baseIRepoListener).newList().collect {
                when (it) {
                    is State.Success -> {
                        initNewList(it.data.data)
                    }

                    is State.Error -> {
                        Print.log("Login View Model ${it.message}")
                    }
                    is State.Loading -> {
                    }
                }
            }
        }
    }

    private fun initNewList(dataList: ArrayList<NewsListData>) {
        newListAdapter = NewListAdapter(dataList, this)
        state = AllNewsState.UpdateNewsList(newListAdapter)
    }
}
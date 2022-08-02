package com.payments.b2b.app_base.viewmodel_base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.payments.b2b.app_base.utils_base.SingleLiveEvent

abstract class BaseViewModel<S> : ViewModel() {

    abstract fun onInitialized(bundle: Bundle?)

    val baseLiveData = SingleLiveEvent<Pair<String, Any>>()

    val stateObserver: SingleLiveEvent<S> by lazy {
        SingleLiveEvent()
    }

    protected fun publishState(state: S) {
        stateObserver.postValue(state)
    }

}
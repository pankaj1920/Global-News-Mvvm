package com.payments.b2b.app_base.listner_base

interface BaseIRepoListener {
    fun showLoader()
    fun hideLoader()
    fun showMessage(message: String)
    fun isNetworkConnected(): Boolean
    fun showErrorMessage(message: String)

}
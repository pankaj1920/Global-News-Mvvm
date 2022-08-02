package com.payments.b2b.app_base.network

object BaseMapping {
    fun getBaseUrl(networkUtils: NetworkUtils): String {
        return when (networkUtils) {
            NetworkUtils.BASE_URL -> "http://192.168.43.40:8080/api/"
//            NetworkUtils.BASE_URL -> "http://192.168.125.40:8080/api/"
        }
    }

}


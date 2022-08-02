package com.payments.b2b.global_news.utils

import com.payments.b2b.global_news.views.activity.home.DashboardActivity

interface Constants {
    interface HandlerTime {
        companion object {
            const val splashTime = 2000L
        }
    }

    interface Activity{
        companion object{
            const val AuthActivity = "com.payments.b2b.global_news.views.activity.authenticate.AuthenticationActivity"
            const val DashboardActivity = "com.payments.b2b.global_news.views.activity.home.DashboardActivity"
        }
    }
}
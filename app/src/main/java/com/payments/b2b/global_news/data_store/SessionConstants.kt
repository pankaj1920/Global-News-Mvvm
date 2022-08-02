package com.payments.b2b.global_news.data_store

import androidx.datastore.preferences.core.stringPreferencesKey

object SessionConstants {
    val ADMIN_TOKEN = stringPreferencesKey("admin_token")
    val ADMIN_ID = stringPreferencesKey("admin_id")
    val ADMIN_EMAIL = stringPreferencesKey("admin_email")
    val ADMIN_FIRST_NAME = stringPreferencesKey("admin_first_name")
    val ADMIN_LAST_NAME = stringPreferencesKey("admin_last_name")
    val ADMIN_MOBILE = stringPreferencesKey("admin_mobile")
    val ADMIN_ADDRESS = stringPreferencesKey("admin_address")
}
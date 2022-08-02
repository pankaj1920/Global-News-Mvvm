package com.payments.b2b.global_news.model.dto


import com.google.gson.annotations.SerializedName

data class AdminRegisterData(
    @SerializedName("address")
    val address: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("is_admin")
    val isAdmin: String,
    @SerializedName("is_staff")
    val isStaff: String,
    @SerializedName("is_superuser")
    val isSuperuser: String,
    @SerializedName("last_login")
    val lastLogin: Any,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("updated_at")
    val updatedAt: String
)
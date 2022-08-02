package com.payments.b2b.global_news.model.response.register

import com.payments.b2b.app_base.model_base.BaseResponse
import com.payments.b2b.global_news.model.dto.AdminRegisterData

data class RegisterResponse(
    val data: AdminRegisterData? = null
) : BaseResponse()

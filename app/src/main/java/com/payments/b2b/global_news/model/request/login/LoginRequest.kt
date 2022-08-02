package com.payments.b2b.global_news.model.request.login

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class LoginRequest(
    email: String = "psb@gmail.com",
    password: String = "psb123",
) : BaseObservable() {

    @get:Bindable
    var email = email
        set(value) {
            if (value != email) {
                field = value
                notifyChange()
            }

        }

    @get:Bindable
    var password = password
        set(value) {
            if (value != password) {
                field = value
                notifyChange()
            }
        }

    override fun toString(): String {
        return "Email => $email Password => $password"
    }
}
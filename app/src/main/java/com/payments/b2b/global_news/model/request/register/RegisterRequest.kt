package com.payments.b2b.global_news.model.request.register

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class RegisterRequest(
    first_name: String = "",
    last_name: String = "",
    email: String = "",
    mobile: String = "",
    address: String = "",
    password: String = ""
) : BaseObservable() {

    @get:Bindable
    var first_name = first_name
        set(value) {
            if (value != first_name) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var last_name = last_name
        set(value) {
            if (value != last_name) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var email = email
        set(value) {
            if (value != email) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var mobile = mobile
        set(value) {
            if (value != mobile) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var address = address
        set(value) {
            if (value != address) {
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
        return "First Name : $first_name Last name: $last_name Email : $email Mobile : $mobile Address : $address Password : $password"
    }
}
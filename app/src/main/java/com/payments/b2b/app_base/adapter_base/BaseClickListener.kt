package com.payments.b2b.app_base.adapter_base

interface BaseClickListener<T> {
    fun onClickItem(data:T,position:Int)
}
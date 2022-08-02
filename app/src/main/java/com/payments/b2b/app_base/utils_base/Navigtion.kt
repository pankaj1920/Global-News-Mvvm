package com.payments.b2b.app_base.utils_base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

fun Activity.navigateTo(bundle: Bundle?, className: String) {
    val i = Intent()
    i.setClassName(this, className)
    if (bundle != null)
        i.putExtras(bundle)
    startActivity(i)
}

fun Activity.navigateToWithResult(bundle: Bundle?, className: String): Intent {
    val i = Intent()
    i.setClassName(this, className)

    if (bundle != null)
        i.putExtras(bundle)
    return i
}

fun Activity.navigateNew(bundle: Bundle?, className: String) {
    val i = Intent()
    i.setClassName(this, className)

    if (bundle != null)
        i.putExtras(bundle)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(i)
    finishAffinity()
}

fun Activity.navigateNewClass(cls: Class<*>) {
    val i = Intent()
    i.setClass(this, cls)
    startActivity(i)
}

//################## Fragment

fun Fragment.navigateTo(bundle: Bundle?, className: String) {
    val i = Intent()
    i.setClassName(requireContext(), className)
    if (bundle != null)
        i.putExtras(bundle)
    startActivity(i)
}

fun Fragment.navigateToWithResult(bundle: Bundle?, className: String): Intent {
    val i = Intent()
    i.setClassName(requireContext(), className)

    if (bundle != null)
        i.putExtras(bundle)
    return i
}

fun Fragment.navigateNew( className: String,bundle: Bundle?) {
    val i = Intent()
    i.setClassName(requireContext(), className)

    if (bundle != null)
        i.putExtras(bundle)
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(i)
    requireActivity().finishAffinity()
}

fun Fragment.navigateNewClass(cls: Class<*>) {
    val i = Intent()
    i.setClass(requireContext(), cls)
    startActivity(i)
}

fun NavController.navigateNew(id: Int, graphId: Int, bundle: Bundle? = null) {
    this.popBackStack(graphId, true)
    if (bundle != null)
        this.navigate(id, bundle)
    else
        this.navigate(id)
}

fun NavController.navigateTo(id: Int, bundle: Bundle? = null) {
    if (bundle != null)
        this.navigate(id, bundle)
    else
        this.navigate(id)
}
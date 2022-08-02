package com.payments.b2b.app_base.utils_base

import android.app.Activity
import androidx.fragment.app.Fragment
import com.payments.b2b.R
import com.payments.b2b.databinding.ErrorLayoutBinding

fun Activity.toastMessage(message: Any?) {
    if (message is String) {
        Toaster.show(this, message)
    } else if (message is Int) {
        Toaster.show(this, message)
    }

}

fun Activity.dismissProgressBar(progressBar: CustomProgressBar?) {
    progressBar?.dialog?.let {
        if (it.isShowing)
            it.dismiss()
    }

}

fun Activity.showProgressBar(progressBar: CustomProgressBar) {
    dismissProgressBar(progressBar)
    //Progress Bar with Text
    progressBar.show(this, null)
}

fun Activity.showProgressBar(progressBar: CustomProgressBar?, message: String?) {
    dismissProgressBar(progressBar)
    //Progress Bar with Text
    progressBar?.show(this, message)
}


fun Fragment.toastMessage(message: Any?) {
    if (message is String) {
        Toaster.show(context!!, message)
    } else if (message is Int) {
        Toaster.show(context!!, message)
    }

}

fun Fragment.dismissProgressBar(progressBar: CustomProgressBar?) {
    progressBar?.dialog?.let {
        if (it.isShowing)
            it.dismiss()
    }
}

fun Fragment.showProgressBar(progressBar: CustomProgressBar) {
    dismissProgressBar(progressBar)
    //Progress Bar with Text
    progressBar.show(context!!, null)
}

fun Fragment.showProgressBar(progressBar: CustomProgressBar?, message: String?) {
    dismissProgressBar(progressBar)
    //Progress Bar with Text
    progressBar?.show(context!!, message)
}

fun Fragment.showError(message: String) {
    val binding: ErrorLayoutBinding = ErrorLayoutBinding.inflate(layoutInflater)
    val alert = CustomDialog(requireContext()).createBottomSheet(binding)
    binding.tvMessage.text = message
    binding.lottieAnim.setAnimation(R.raw.network_error)
    binding.ivClose.setOnClickListener {
        alert.second.dismiss()
        requireActivity().finish()
    }
    binding.ivMinimise.setOnClickListener {
        alert.second.dismiss()
    }
    binding.ivShare.setOnClickListener {
        BaseUtils.shareOnAllApps(requireContext(), message)
    }
}
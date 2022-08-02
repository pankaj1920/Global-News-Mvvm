package com.payments.b2b.app_base.view_base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.payments.b2b.R
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.*
import com.payments.b2b.app_base.utils_base.session.SessionManager
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseFragment<VM : BaseViewModel<*>, VB : ViewDataBinding> : Fragment(),
    BaseIRepoListener {

    protected abstract val mViewModel: BaseViewModel<*>

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun subscribeObservers()

    abstract fun onFragmentCreated()

    lateinit var mViewBinding: VB

    lateinit var iRepositoryListener: BaseIRepoListener

    private val progressBar: CustomProgressBar by lazy {
        CustomProgressBar()
    }

    val sessionManager: SessionManager by lazy {
        SessionManager(requireContext())
    }

    private val codeSnippet: CodeSnippet by lazy {
        CodeSnippet(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        if (::mViewBinding.isInitialized.not()) {
            mViewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            mViewBinding.lifecycleOwner = viewLifecycleOwner
        }
        // mViewBinding = activity?.let { DataBindingUtil.setContentView(it, layoutId) }!!
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.Main) {
            async { subscribeObservers() }.await()

            iRepositoryListener = this@BaseFragment

            mViewModel.onInitialized(arguments)

            onFragmentCreated()

            initLoader()
        }
    }


    private fun initLoader() {
        mViewModel.baseLiveData.observe(viewLifecycleOwner) {
            when (it.first) {
                BaseConstants.BaseKeys.SHOW_LOADER -> showLoader()
                BaseConstants.BaseKeys.SHOW_LOADER_MESSAGE -> showMessage(it.second as String)
                BaseConstants.BaseKeys.HIDE_LOADER -> hideLoader()
                BaseConstants.BaseKeys.SHOW_MESSAGE -> showMessage(it.second as String)
            }
        }
    }

    override fun showLoader() {
        showProgressBar(progressBar)
    }

    override fun hideLoader() {
        dismissProgressBar(progressBar)
    }

    override fun showMessage(message: String) {
        toastMessage(message)
    }

    override fun isNetworkConnected(): Boolean {
        val isConnected = NetworkConnection(requireContext()).hasNetworkConnection()
        if (isConnected.not()) {
            showMessage(getString(R.string.not_internet_connection))
            Print.log(getString(R.string.not_internet_connection))
        }
        return isConnected
    }

    override fun showErrorMessage(message: String) {
        Print.log("Error Message => $message")
    }
}
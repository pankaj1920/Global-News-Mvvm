package com.payments.b2b.app_base.view_base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.payments.b2b.R
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.*
import com.payments.b2b.app_base.utils_base.session.SessionManager
import com.payments.b2b.app_base.viewmodel_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseActivity<VM : BaseViewModel<*>, VB : ViewDataBinding> : AppCompatActivity(),
    BaseIRepoListener {

    protected abstract val mViewModel: BaseViewModel<*>

    @get:LayoutRes
    abstract val layoutId: Int?

    abstract fun onInitialize()

    abstract fun subscribeObservers()

    lateinit var iRepositoryListener: BaseIRepoListener

    private lateinit var mViewBinding: VB

    private var mParentView: View? = null

    fun getRepositoryListener(): BaseIRepoListener = iRepositoryListener

    private val progressBar: CustomProgressBar by lazy {
        CustomProgressBar()
    }

    val sessionManager: SessionManager by lazy {
        SessionManager(this)
    }

    private val codeSnippet: CodeSnippet by lazy {
        CodeSnippet(this)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        mParentView = window.decorView.findViewById(android.R.id.content)
        return super.onCreateView(name, context, attrs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this@BaseActivity.layoutId?.let { layoutId ->
            mViewBinding = DataBindingUtil.setContentView(this, layoutId)
        }

        iRepositoryListener = this@BaseActivity

        lifecycleScope.launch(Dispatchers.Main) {
            async { subscribeObservers() }.await()
            mViewModel.onInitialized(intent.extras)
            onInitialize()
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
        val isConnected = NetworkConnection(this).hasNetworkConnection()
        if (isConnected.not()) {
            showMessage(getString(R.string.not_internet_connection))
            Print.log(getString(R.string.not_internet_connection))
        }
        return isConnected
    }

    override fun showErrorMessage(message: String) {
        Print.log("Error Message : $message")
    }
}




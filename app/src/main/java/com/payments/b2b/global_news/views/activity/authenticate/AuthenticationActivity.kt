package com.payments.b2b.global_news.views.activity.authenticate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.payments.b2b.R
import com.payments.b2b.databinding.ActivityAuthentaionBinding

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAuthentaionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_authentaion)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.auth_nav_host_fragment) as NavHostFragment
//            binding.authNavHostFragment as NavHostFragment
        val navController = navHostFragment.navController
    }
}
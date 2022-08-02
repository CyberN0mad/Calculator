package com.hfad.attractorassignment.ui

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.hfad.attractorassignment.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.hfad.attractorassignment.core.ui.base.BaseFragment
import com.hfad.attractorassignment.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate){

    override val viewModel: ViewModel by viewModel()

    override fun setupLiveData() {
    }

    override fun setupUI() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.navigation_home)
        }, 4000)
    }
}
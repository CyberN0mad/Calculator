package com.hfad.attractorassignment.ui.home

import com.hfad.attractorassignment.databinding.FragmentHomeBinding
import com.hfad.attractorassignment.core.ui.base.BaseFragment
import com.hfad.attractorassignment.repository.UserDataView
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    override fun setupLiveData() {
        viewModel.getData()
        viewModel.userLiveData.observe(viewLifecycleOwner){
           updateControls(it)
        }
    }

    private fun updateControls(userData: UserDataView?){

        userData?.photo?.let { binding.imageProfile.setImageResource(it) }

        binding.textFirstName.text = userData?.name
        binding.textSecondName.text = userData?.secondName
        binding.textEducation.text = userData?.education

        binding.textWorkFirst.text = userData?.company?.get(0)?.name ?: ""
        binding.textPositionFirst.text = userData?.company?.get(0)?.position ?: ""

        binding.textWorkSecond.text = userData?.company?.get(1)?.name ?: ""
        binding.textPositionSecond.text = userData?.company?.get(1)?.position ?: ""
    }

    override fun setupUI() {}
}
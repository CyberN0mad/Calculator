package com.hfad.attractorassignment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.attractorassignment.repository.MainRepo
import com.hfad.attractorassignment.repository.UserDataView

class HomeViewModel(private val repo: MainRepo) : ViewModel() {

    private var _userLiveData = MutableLiveData<UserDataView?>()
    var userLiveData: LiveData<UserDataView?> = _userLiveData

    fun getData() {
        _userLiveData.value = repo.getUserData()
    }
}
package com.hfad.attractorassignment.ui.gallery

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private var _imageList = MutableLiveData<MutableList<Uri>>()
    var imageList: LiveData<MutableList<Uri>> = _imageList

    fun setData(listUri: MutableList<Uri>){
        _imageList.value = listUri
    }
}
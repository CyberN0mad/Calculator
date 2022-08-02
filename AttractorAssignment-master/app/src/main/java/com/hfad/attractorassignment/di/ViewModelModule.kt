package com.hfad.attractorassignment.di

import com.hfad.attractorassignment.ui.gallery.GalleryViewModel
import com.hfad.attractorassignment.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { GalleryViewModel() }
}
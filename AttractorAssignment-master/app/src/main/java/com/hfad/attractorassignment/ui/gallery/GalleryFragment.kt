package com.hfad.attractorassignment.ui.gallery

import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.hfad.attractorassignment.core.ui.base.BaseFragment
import com.hfad.attractorassignment.databinding.FragmentGalleryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(FragmentGalleryBinding::inflate) {

    override val viewModel: GalleryViewModel by viewModel()

    private  lateinit var adapter: ImageListAdapter

    private val getContent: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetMultipleContents()){ list ->
            viewModel.setData(list)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ImageListAdapter(null)
    }

    override fun setupUI() {
        upDateControls()
        binding.btnOpen.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    override fun setupLiveData() {
        viewModel.imageList.observe(viewLifecycleOwner){ list ->
            adapter.swapData(list)
        }
    }

    private fun upDateControls() {
        binding.recyclerView.adapter = adapter
    }
}
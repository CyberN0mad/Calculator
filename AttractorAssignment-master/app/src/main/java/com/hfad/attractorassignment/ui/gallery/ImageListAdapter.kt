package com.hfad.attractorassignment.ui.gallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.attractorassignment.databinding.ItemGalleryBinding

class ImageListAdapter(
  private var listUri: MutableList<Uri>?,
) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>(){

  inner class ViewHolder(
    databinding: ItemGalleryBinding
  ) : RecyclerView.ViewHolder(databinding.root) {
    val imageView: ImageView = databinding.imageView
  }

  fun swapData(imageList: MutableList<Uri>) {
    this.listUri = imageList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.ViewHolder {
    return ViewHolder(ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val pickedImageList = listUri ?: return
    val pickedImage =  pickedImageList[position]
    holder.imageView.setImageURI(pickedImage)
  }

  override fun getItemCount(): Int {
    return listUri?.size ?: 0
  }
}
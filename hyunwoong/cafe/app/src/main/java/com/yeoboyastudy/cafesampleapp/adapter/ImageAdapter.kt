package com.yeoboyastudy.cafesampleapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yeoboyastudy.cafesampleapp.data.ChatData
import com.yeoboyastudy.cafesampleapp.data.PhotoResponse
import com.yeoboyastudy.cafesampleapp.databinding.ItemImageBinding

class ImageAdapter(
    private val onClick: (String) -> Unit
): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val adapterList = mutableListOf<PhotoResponse>()

    fun set(list: List<PhotoResponse>) {
        adapterList.clear()
        adapterList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = adapterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(adapterList[position])
    }


    inner class ViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(image: PhotoResponse) {
            Glide.with(binding.root)
                .load(image.urls.regular)
                .thumbnail(Glide.with(binding.root).load(image.urls.thumb).transition(DrawableTransitionOptions.withCrossFade()))
                .centerCrop()
                .into(binding.searchImage)

            binding.root.setOnClickListener {
                onClick.invoke(image.urls.regular)
            }
        }
    }
}
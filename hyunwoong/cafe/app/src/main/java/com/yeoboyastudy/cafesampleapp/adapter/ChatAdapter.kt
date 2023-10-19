package com.yeoboyastudy.cafesampleapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeoboyastudy.cafesampleapp.data.ChatData
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageImageLeftBinding
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageImageRightBinding
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageTextLeftBinding
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageTextRightBinding
import com.yeoboyastudy.cafesampleapp.dialog.GalleryDialog

enum class ChatViewType {
    TEXT_LEFT, TEXT_RIGHT,
    IMAGE_LEFT, IMAGE_RIGHT
}

class ChatAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    val adapterList = mutableListOf<ChatData>()

    fun set(list: List<ChatData>) {
        adapterList.clear()
        adapterList.addAll(list)
        notifyDataSetChanged()
    }

    fun addMessage(message: ChatData) {
        adapterList.add(message)
        notifyItemInserted(adapterList.lastIndex)
    }

    fun lastMessageIsMe() = if(adapterList.isEmpty()) true
        else (adapterList.last() as ChatData.BaseItem).isMe

    override fun getItemViewType(position: Int): Int {
        return when(val msgItem = adapterList.getOrNull(position)) {
            is ChatData.TextItem -> {
                if(msgItem.isMe) ChatViewType.TEXT_RIGHT.ordinal else ChatViewType.TEXT_LEFT.ordinal
            }
            is ChatData.ImageItem -> {
                if(msgItem.isMe) ChatViewType.IMAGE_RIGHT.ordinal else ChatViewType.IMAGE_LEFT.ordinal
            }
            else -> ChatViewType.TEXT_RIGHT.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ChatViewType.TEXT_RIGHT.ordinal -> {
                TextRightViewHolder(
                    ItemMessageTextRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            ChatViewType.TEXT_LEFT.ordinal -> {
                TextLeftViewHolder(
                    ItemMessageTextLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            ChatViewType.IMAGE_RIGHT.ordinal -> {
                ImageRightViewHolder(
                    ItemMessageImageRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                ImageLeftViewHolder(
                    ItemMessageImageLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is TextLeftViewHolder -> {
                holder.bind(position)
            }
            is TextRightViewHolder -> {
                holder.bind(position)
            }
            is ImageRightViewHolder -> {
                holder.bind(position)
            }
            is ImageLeftViewHolder -> {
                holder.bind(position)
            }
        }
    }

    inner class TextLeftViewHolder(private val binding: ItemMessageTextLeftBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val data = adapterList[position] as ChatData.TextItem
            tvMessage.text = data.message
        }
    }

    inner class TextRightViewHolder(private val binding: ItemMessageTextRightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val data = adapterList[position] as ChatData.TextItem
            tvMessage.text = data.message
        }
    }

    inner class ImageRightViewHolder(private val binding: ItemMessageImageRightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val data = adapterList[position] as ChatData.ImageItem
            Glide.with(binding.root)
                .load(data.url)
                .centerCrop()
                .into(imageView)
        }
    }

    inner class ImageLeftViewHolder(private val binding: ItemMessageImageLeftBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val data = adapterList[position] as ChatData.ImageItem
            Glide.with(binding.root)
                .load(data.url)
                .centerCrop()
                .into(imageView)
        }
    }
}
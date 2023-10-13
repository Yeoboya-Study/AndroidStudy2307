package com.yeoboyastudy.cafesampleapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeoboyastudy.cafesampleapp.data.ChatData
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageTextLeftBinding
import com.yeoboyastudy.cafesampleapp.databinding.ItemMessageTextRightBinding

enum class ChatViewType {
    TEXT_LEFT, TEXT_RIGHT,
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

    override fun getItemViewType(position: Int): Int {
        return if(adapterList[position].isMe) {
            ChatViewType.TEXT_RIGHT.ordinal
        }
        else ChatViewType.TEXT_LEFT.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ChatViewType.TEXT_RIGHT.ordinal -> {
                TextRightViewHolder(
                    ItemMessageTextRightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                TextLeftViewHolder(
                    ItemMessageTextLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(holder) {
            is TextLeftViewHolder -> {
                holder.bind(adapterList[position])
            }
            is TextRightViewHolder -> {
                holder.bind(adapterList[position])
            }
            else -> {
            }
        }
    }

    inner class TextLeftViewHolder(private val binding: ItemMessageTextLeftBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: ChatData) = with(binding) {
            tvMessage.text = message.message
        }
    }

    inner class TextRightViewHolder(private val binding: ItemMessageTextRightBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: ChatData) = with(binding) {
            tvMessage.text = message.message
        }
    }
}
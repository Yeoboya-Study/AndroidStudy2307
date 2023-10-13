package com.yeoboyastudy.cafesampleapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeoboyastudy.cafesampleapp.adapter.ChatAdapter
import com.yeoboyastudy.cafesampleapp.data.ChatData
import com.yeoboyastudy.cafesampleapp.databinding.FragmentChatBinding

class ChatFragment: Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    private val chatLayoutManager by lazy {
        LinearLayoutManager(requireContext()).apply {
            stackFromEnd = true
        }
    }

    private val chatAdapter by lazy {
        ChatAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
        bindRecyclerView()
    }

    private fun setOnClick() = with(binding) {
        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            if(message.isNotEmpty()) {
                val isMe = if(chatAdapter.adapterList.isEmpty()) true
                else {
                    !chatAdapter.adapterList.last().isMe
                }
                chatAdapter.addMessage(ChatData(message, isMe))
                etMessage.text.clear()
                recyclerView.scrollToPosition(chatAdapter.adapterList.lastIndex)
            }
        }
    }

    private fun bindRecyclerView() = with(binding) {
        recyclerView.apply {
            adapter = chatAdapter
            layoutManager = chatLayoutManager
        }
        chatAdapter.set(listOf())
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
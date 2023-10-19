package com.yeoboyastudy.cafesampleapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeoboyastudy.cafesampleapp.R
import com.yeoboyastudy.cafesampleapp.adapter.ChatAdapter
import com.yeoboyastudy.cafesampleapp.data.ChatData
import com.yeoboyastudy.cafesampleapp.databinding.FragmentChatBinding
import com.yeoboyastudy.cafesampleapp.dialog.GalleryDialog
import com.yeoboyastudy.cafesampleapp.extension.addFragment
import com.yeoboyastudy.cafesampleapp.extension.removeFragment

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

    private val bottomMenuFragment by lazy {
        ChatBottomFragment().apply {
            bottomResult = {
                sendMessage(ChatData.ImageItem(it, !chatAdapter.lastMessageIsMe()))
            }
        }
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
                sendMessage(ChatData.TextItem(message, !chatAdapter.lastMessageIsMe()))
                etMessage.text.clear()
                recyclerView.scrollToPosition(chatAdapter.adapterList.lastIndex)
            }
        }

        btnPlus.setOnClickListener {
            if(childFragmentManager.findFragmentById(R.id.containerView) != bottomMenuFragment)
                addFragment(R.id.containerView, bottomMenuFragment)
            else removeFragment(R.id.containerView, bottomMenuFragment)
        }
    }

    private fun bindRecyclerView() = with(binding) {
        recyclerView.apply {
            adapter = chatAdapter
            layoutManager = chatLayoutManager
        }
        chatAdapter.set(listOf())
    }

    private fun sendMessage(data: ChatData) {
        chatAdapter.addMessage(data)
        binding.recyclerView.scrollToPosition(chatAdapter.adapterList.lastIndex)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
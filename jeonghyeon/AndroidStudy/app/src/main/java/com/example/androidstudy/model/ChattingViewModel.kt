package com.example.androidstudy.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudy.data.ChatData

class ChattingViewModel : ViewModel() {

    private var _chatList : MutableLiveData<MutableList<ChatData>> = MutableLiveData(mutableListOf())
    val chatList get() = _chatList

    fun sendChatting(chatData: ChatData) {
        _chatList.value!!.add(0, chatData)
        _chatList.postValue(_chatList.value)
    }
}
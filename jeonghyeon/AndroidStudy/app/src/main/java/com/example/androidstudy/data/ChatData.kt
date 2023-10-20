package com.example.androidstudy.data

sealed class ChatData {

    interface Base {
        val isMe: Boolean
    }

    data class TextChat(
        val msg: String,
        override val isMe: Boolean
    ) : ChatData(), Base

    data class ImgChat(
        override val isMe: Boolean,
        val img: String
    ) : ChatData(), Base

    data class TextWithImgChat(
        val msg : String,
        override val isMe: Boolean,
        val img : String
    ) : ChatData(), Base
}
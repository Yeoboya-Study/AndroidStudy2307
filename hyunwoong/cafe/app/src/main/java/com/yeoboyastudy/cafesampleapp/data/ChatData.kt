package com.yeoboyastudy.cafesampleapp.data

sealed class ChatData {

    interface BaseItem {
        val isMe: Boolean
    }

    data class TextItem(
        val message: String,
        override val isMe: Boolean = true
    ): ChatData(), BaseItem

    data class ImageItem(
        val url: String,
        override val isMe: Boolean = true
    ): ChatData(), BaseItem
}
package com.yeoboyastudy.cafesampleapp.data


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("blur_hash")
    val blurHash: String,
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    val likes: Int,
    val links: Links,
    @SerializedName("updated_at")
    val updatedAt: String,
    val urls: Urls,
    val width: Int
)
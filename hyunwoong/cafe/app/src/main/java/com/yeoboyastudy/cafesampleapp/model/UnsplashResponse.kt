package com.yeoboyastudy.cafesampleapp.model

data class UnsplashResponse(val result: List<PhotoData>)
data class PhotoData(val id: String, val url: String)

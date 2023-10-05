package com.yeoboyastudy.cafesampleapp.rest

import com.yeoboyastudy.cafesampleapp.BuildConfig
import com.yeoboyastudy.cafesampleapp.data.PhotoResponse
import com.yeoboyastudy.cafesampleapp.model.UnsplashResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {


    @GET("photos/random?" + "client_id=${BuildConfig.UNSPLASH_ACCESS_KEY}" + "&count=30")

    suspend fun getRandomPhotos(
        @Query("query") query: String?
    ): Response<List<PhotoResponse>>
}
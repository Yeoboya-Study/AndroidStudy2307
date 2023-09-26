package com.yeoboyastudy.cafesampleapp.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UnsplashApiClient {
    private const val BASE_URL = "https://api.unsplash.com/"
    private const val CLIENT_ID = "YOUR_UNSPLASH_API_KEY"

    val unsplashApiService: UnsplashApiService by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .header("Accept-Version", "v1")
                    .build()
                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(UnsplashApiService::class.java)
    }
}
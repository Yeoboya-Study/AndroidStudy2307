package com.yeoboyastudy.cafesampleapp.rest

import com.yeoboyastudy.cafesampleapp.BuildConfig
import com.yeoboyastudy.cafesampleapp.data.PhotoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object UnsplashApiClient {
    private const val BASE_URL = "https://api.unsplash.com/"
    private const val CLIENT_ID = "YOUR_UNSPLASH_API_KEY"

    // 레트로핏으로 생성
    private val unsplashApiService: UnsplashApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOkHttpClient())
            .build()
            .create()
    }
    // 실제로 호출할 수 있는 호출부 구현
    suspend fun getRandomPhotos(query: String?): List<PhotoResponse>? =
        unsplashApiService.getRandomPhotos(query).body()

    // 로깅 찍기 위해 OkHttpClient 추가
    private fun buildOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .build()

}
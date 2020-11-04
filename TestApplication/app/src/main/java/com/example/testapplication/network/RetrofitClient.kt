package com.example.testapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "https://api.themoviedb.org"

    private var mInstance: RetrofitClient? = null
    private var apiInterface: MyInterface? = null

    val instance: RetrofitClient
        get() {
            if (mInstance == null) {
                mInstance = RetrofitClient
            }
            return mInstance as RetrofitClient
        }

    fun getApiInterface(): MyInterface? {
        if (apiInterface == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)  // <-- this is the important line!
            apiInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MyInterface::class.java)
        }
        return apiInterface
    }
}
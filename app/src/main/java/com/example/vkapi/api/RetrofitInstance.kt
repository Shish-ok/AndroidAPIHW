package com.example.vkapi.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val token = "b7e5a734b7e5a734b7e5a73415b4f4792fbb7e5b7e5a734d47d326b479957158ca0612d"
    private const val apiVersion = "5.131"

    private val retrofit by lazy {
        Retrofit.Builder().
        baseUrl("https://api.vk.com/method/").
        addConverterFactory(GsonConverterFactory.create()).
        client(
            OkHttpClient.Builder().
                    addInterceptor {
                        chain ->
                        val url = chain.
                            request().
                            url().
                            newBuilder().
                            addQueryParameter("v", apiVersion).
                            addQueryParameter("access_token", token).
                            build()
                        chain.proceed(chain.request().newBuilder().url(url).build())
                    }
                    .build()
        ).build()
    }

    val api: CoreAPI by lazy {
        retrofit.create(CoreAPI::class.java)
    }
}
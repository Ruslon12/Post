package com.example.post.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://plain-cod-wetsuit.cyclic.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: Service = retrofit.create(Service::class.java)
}
package com.example.post.network

import com.example.post.dto.GetPost
import com.example.post.dto.ResponseSetPost
import com.example.post.dto.SetPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @GET("posts")
    fun getPost() : Call<GetPost>

    @POST("posts")
    fun setPost(@Body post: SetPost) : Call<ResponseSetPost>
}
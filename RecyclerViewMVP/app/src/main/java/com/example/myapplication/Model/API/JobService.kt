package com.example.myapplication.Model.API

import com.example.myapplication.Model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JobService {
    @GET("posts")
    fun getAllPosts():Call<ArrayList<DataModel>>

    @GET("posts")
    fun getPost():Call<DataModel>
}
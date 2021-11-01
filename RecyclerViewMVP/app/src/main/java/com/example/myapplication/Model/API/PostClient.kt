package com.example.myapplication.Model.API


import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Model.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//singleton class PostClient
object PostClient
{
    private var BASE_URL:String="https://jsonplaceholder.typicode.com/"
    private var jobService:JobService

    init
    {
        val retrofit:Retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        jobService=retrofit.create(JobService::class.java)
    }
    fun getPosts():Call<ArrayList<DataModel>>
    {
        return jobService.getAllPosts()
    }
    fun getPost():Call<DataModel>
    {
        return jobService.getPost()
    }
}
package com.example.onlinefood.api

import com.example.onlinefood.responce.Category
import com.example.onlinefood.responce.foodResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
   @GET("/api/json/v1/1/categories.php")
   fun getData(@Query("tagged") tags: String): Call<foodResponce>
}


package com.example.mvvmbasickotlin.data.network

import com.example.mvvmbasickotlin.data.network.response.LoginResponse
import com.example.mvvmbasickotlin.data.network.response.SignupResponse
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyApi {

    @Headers("Accept: application/json", "Content-Type:application/json")
    @POST("login")
    suspend fun userLogin(@Body rawLogin: JsonObject) : Response<LoginResponse>

    @Headers("Accept: application/json", "Content-Type:application/json")
    @POST("register")
    suspend fun userRegister(@Body rawLogin: JsonObject) : Response<SignupResponse>

    companion object{
        operator fun invoke() : MyApi{
            return Retrofit.Builder().baseUrl("http://192.168.100.11:8000/api/auth/").addConverterFactory(GsonConverterFactory.create()).build().create(MyApi::class.java)
        }
    }


}
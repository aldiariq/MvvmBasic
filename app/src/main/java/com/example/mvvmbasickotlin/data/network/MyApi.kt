package com.example.mvvmbasickotlin.data.network

import com.example.mvvmbasickotlin.data.network.response.LoginResponse
import com.example.mvvmbasickotlin.data.network.response.SignupResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("remember") remember : Int
    ) : Response<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    suspend fun userRegister(
        @Field("email") email : String,
        @Field("name") name : String,
        @Field("password") password : String
    ) : Response<SignupResponse>

    companion object{
        operator fun invoke() : MyApi{
            return Retrofit.Builder().baseUrl("http://192.168.100.11:8000/api/auth/").addConverterFactory(GsonConverterFactory.create()).build().create(MyApi::class.java)
        }
    }


}
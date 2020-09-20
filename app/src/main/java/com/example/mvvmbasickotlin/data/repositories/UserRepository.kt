package com.example.mvvmbasickotlin.data.repositories

import com.example.mvvmbasickotlin.data.network.MyApi
import com.example.mvvmbasickotlin.data.network.response.LoginResponse
import com.example.mvvmbasickotlin.data.network.response.SignupResponse
import com.google.gson.JsonObject
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String , remember: Int) : Response<LoginResponse> {
        return MyApi().userLogin(email, password, remember)
    }

    suspend fun userRegister(email: String, name: String, password: String) : Response<SignupResponse> {
        return MyApi().userRegister(email, name, password)
    }
}
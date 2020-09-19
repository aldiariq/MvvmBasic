package com.example.mvvmbasickotlin.data.repositories

import com.example.mvvmbasickotlin.data.network.MyApi
import com.example.mvvmbasickotlin.data.network.response.LoginResponse
import com.example.mvvmbasickotlin.data.network.response.SignupResponse
import com.google.gson.JsonObject
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String , remember: Boolean) : Response<LoginResponse> {
        val rawLogin = JsonObject()
        rawLogin.addProperty("email", email)
        rawLogin.addProperty("password", password)
        rawLogin.addProperty("remember", remember)

        return MyApi().userLogin(rawLogin)
    }

    suspend fun userRegister(email: String, name: String, password: String) : Response<SignupResponse> {
        val rawSignup = JsonObject()
        rawSignup.addProperty("email", email)
        rawSignup.addProperty("name", name)
        rawSignup.addProperty("password", password)

        return MyApi().userRegister(rawSignup)
    }
}
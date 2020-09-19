package com.example.mvvmbasickotlin.data.network.response

import com.example.mvvmbasickotlin.data.db.entities.User

data class LoginResponse(
    val isSuccessful : Boolean?,
    val message : String?,
    val access_token : String?,
    val token_type : String?,
    val expires_at : String?,
    val user : User?
)
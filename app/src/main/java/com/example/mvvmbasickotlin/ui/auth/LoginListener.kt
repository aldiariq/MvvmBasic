package com.example.mvvmbasickotlin.ui.auth

import com.example.mvvmbasickotlin.data.db.entities.User

interface LoginListener {
    fun onStarted()
    fun onSuccesslogin(user: User)
    fun onFailure(message: String)
}
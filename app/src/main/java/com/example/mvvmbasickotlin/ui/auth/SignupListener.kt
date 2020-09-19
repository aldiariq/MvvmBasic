package com.example.mvvmbasickotlin.ui.auth

import androidx.lifecycle.LiveData
import com.example.mvvmbasickotlin.data.db.entities.User
import com.example.mvvmbasickotlin.data.network.response.SignupResponse

interface SignupListener {
    fun onStarted()
    fun onSuccessregister(message: String)
    fun onFailure(message: String)
}
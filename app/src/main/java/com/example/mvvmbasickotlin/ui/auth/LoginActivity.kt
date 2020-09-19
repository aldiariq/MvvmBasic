package com.example.mvvmbasickotlin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasickotlin.R
import com.example.mvvmbasickotlin.data.db.entities.User
import com.example.mvvmbasickotlin.databinding.ActivityLoginBinding
import com.example.mvvmbasickotlin.util.toast

class LoginActivity : AppCompatActivity(), LoginListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.loginListener = this
    }

    override fun onStarted() {

    }

    override fun onSuccesslogin(user: User) {
        toast("${user.name} Berhasil Login")
    }

    override fun onFailure(message: String) {
        toast("Login Gagal")
    }
}
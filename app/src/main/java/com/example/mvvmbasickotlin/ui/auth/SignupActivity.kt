package com.example.mvvmbasickotlin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasickotlin.R
import com.example.mvvmbasickotlin.data.network.response.SignupResponse
import com.example.mvvmbasickotlin.databinding.ActivitySignupBinding
import com.example.mvvmbasickotlin.util.toast

class SignupActivity : AppCompatActivity(), SignupListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        val viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.signupListener = this
    }

    override fun onStarted() {
    }

    override fun onSuccessregister(message: String) {
        toast(message)
    }

    override fun onFailure(message: String) {
        toast("Registrasi Gagal")
    }

}
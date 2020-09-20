package com.example.mvvmbasickotlin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasickotlin.R
import com.example.mvvmbasickotlin.data.db.entities.User
import com.example.mvvmbasickotlin.databinding.ActivityLoginBinding
import com.example.mvvmbasickotlin.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.loginListener = this
    }

    override fun onStarted() {
        pblogin.setVisibility(View.VISIBLE);
    }

    override fun onSuccesslogin(user: User) {
        pblogin.setVisibility(View.GONE)
        toast("${user.name} Berhasil Login")
    }

    override fun onFailure(message: String) {
        pblogin.setVisibility(View.GONE)
        toast("Login Gagal")
    }
}
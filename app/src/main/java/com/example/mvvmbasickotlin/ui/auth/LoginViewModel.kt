package com.example.mvvmbasickotlin.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmbasickotlin.data.repositories.UserRepository
import com.example.mvvmbasickotlin.util.Coroutines

class LoginViewModel : ViewModel() {

    var emaillogin: String? = null
    var passwordlogin: String? = null
    var loginListener: LoginListener? = null

    fun onLoginButtonClickLogin(view: View){
        loginListener?.onStarted()
        if(emaillogin.isNullOrEmpty() || passwordlogin.isNullOrEmpty()){
            loginListener?.onFailure("Pastikan Data Terisi")
            return
        }

        Coroutines.main {
            val response = UserRepository().userLogin(emaillogin!!, passwordlogin!!, 0)

            if (response.isSuccessful){
                loginListener?.onSuccesslogin(response.body()?.user!!)
            }else {
                loginListener?.onFailure("Error Code : ${response.code()}")
            }
        }
    }

    fun onRegisterButtonClickLogin(view: View){
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}
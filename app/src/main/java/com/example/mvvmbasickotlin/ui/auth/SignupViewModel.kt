package com.example.mvvmbasickotlin.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmbasickotlin.data.repositories.UserRepository
import com.example.mvvmbasickotlin.util.Coroutines

class SignupViewModel : ViewModel() {
    var emailsignup: String? = null
    var namesignup: String? = null
    var password1signup: String? = null
    var password2signup: String? = null

    var signupListener: SignupActivity? = null

    fun onRegisButtonClickSignup(view : View){
        signupListener?.onStarted()
        if (emailsignup.isNullOrEmpty() || namesignup.isNullOrEmpty() || password1signup.isNullOrEmpty() || password2signup.isNullOrEmpty()){
            signupListener?.onFailure("Pastikan Data Terisi")
            return
        }

        if (!password1signup.equals(password2signup)){
            signupListener?.onFailure("Pastikan Password Sama")
            return
        }

        Coroutines.main {
            val response = UserRepository().userRegister(emailsignup!!, namesignup!!, password1signup!!)
            if (response.isSuccessful){
                signupListener?.onSuccessregister(response.body()?.message!!)
            }else {
                signupListener?.onFailure("Error Code : ${response.code()}")
            }
        }
    }

    fun onLoginButtonClickSignup(view: View){
        Intent(view.context, LoginActivity::class.java).also {
            
            view.context.startActivity(it)
        }
    }
}
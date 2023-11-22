package edu.hardwork.mvvmmodel.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import edu.hardwork.mvvmmodel.ui.auth.AuthListener

class AuthViewModel : ViewModel() {

    var email: String? = null
    var name: String? = null
    var password: String? = null
    var cpassword: String? = null


    var authListener: AuthListener? = null

    fun onLoginButtonCLick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        authListener?.onSuccess()
        Log.i("MY TAG", email!!)
        Log.i("MY TAG", password!!)


    }

    fun onSignUpButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()||name.isNullOrEmpty()||cpassword.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        authListener?.onSuccess()
        Log.i("My TAG",name!!)
        Log.i("MY TAG", email!!)
        Log.i("MY TAG", password!!)

    }

}
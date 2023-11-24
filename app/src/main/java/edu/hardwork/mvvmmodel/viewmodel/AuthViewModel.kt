package edu.hardwork.mvvmmodel.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import edu.hardwork.mvvmmodel.data.repository.UserRepository
import edu.hardwork.mvvmmodel.ui.auth.AuthListener
import edu.hardwork.mvvmmodel.utils.Coroutines

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
    Coroutines.main {
        val response = UserRepository().userLogin(email!!,password!!)
        if(response.isSuccessful){
            response.body()?.user!!.token = response.body()?.token
            authListener?.onSuccess(response.body()?.user!!)
        }else{
            authListener?.onFailure("Error Code: ${response.code()} ")
        }
    }

        Log.i("MY TAG", email!!)
        Log.i("MY TAG", password!!)


    }

    fun onSignUpButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()||name.isNullOrEmpty()||cpassword.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
//        authListener?.onSuccess(loginResponse)
        Log.i("My TAG",name!!)
        Log.i("MY TAG", email!!)
        Log.i("MY TAG", password!!)

    }

}
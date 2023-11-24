package edu.hardwork.mvvmmodel.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.hardwork.mvvmmodel.data.network.AuthResponse
import edu.hardwork.mvvmmodel.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return  MyApi().userLogin(email,password)
    }
}
package edu.hardwork.mvvmmodel.data.network

import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        email:String,
        password:String
    )
}
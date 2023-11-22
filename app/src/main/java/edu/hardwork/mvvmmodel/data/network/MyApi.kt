package edu.hardwork.mvvmmodel.data.network


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
    @POST("users/login")
    fun userLogin(
       @Field("email") email:String,
       @Field("password") password:String
    ): Call<ResponseBody>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:82/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}
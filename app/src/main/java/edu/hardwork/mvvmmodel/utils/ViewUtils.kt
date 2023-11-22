package edu.hardwork.mvvmmodel.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(message:String){
    Log.i("TOAST",message)
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}
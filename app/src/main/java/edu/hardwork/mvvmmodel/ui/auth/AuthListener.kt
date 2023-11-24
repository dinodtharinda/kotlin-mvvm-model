package edu.hardwork.mvvmmodel.ui.auth

import androidx.lifecycle.LiveData
import edu.hardwork.mvvmmodel.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess( user: User)
    fun onFailure(message:String)

}
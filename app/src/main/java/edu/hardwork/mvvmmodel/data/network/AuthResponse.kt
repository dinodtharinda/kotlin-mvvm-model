package edu.hardwork.mvvmmodel.data.network

import edu.hardwork.mvvmmodel.data.db.entities.User

data class AuthResponse(val isSuccessful: Boolean?, val message: String?, val user: User?,val token :String?)
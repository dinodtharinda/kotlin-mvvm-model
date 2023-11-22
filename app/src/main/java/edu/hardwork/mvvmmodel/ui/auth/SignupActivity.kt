package edu.hardwork.mvvmmodel.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import edu.hardwork.mvvmmodel.R
import edu.hardwork.mvvmmodel.databinding.ActivitySignupBinding
import edu.hardwork.mvvmmodel.utils.toast
import edu.hardwork.mvvmmodel.viewmodel.AuthViewModel

class SignupActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding  = DataBindingUtil.setContentView<ActivitySignupBinding>(this,R.layout.activity_signup)
        var viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener= this
    }



    override fun onStarted() {
        toast("Started Sign Up")
    }

    override fun onSuccess() {
        toast("Success Sign UP")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
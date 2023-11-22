package edu.hardwork.mvvmmodel.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.hardwork.mvvmmodel.R
import edu.hardwork.mvvmmodel.databinding.ActivityLoginBinding
import edu.hardwork.mvvmmodel.utils.toast
import edu.hardwork.mvvmmodel.viewmodel.AuthViewModel
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.ByteString.Companion.encode

class LoginActivity : AppCompatActivity() ,AuthListener{
    var progresssBar:ProgressBar? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :ActivityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener= this

        var btnOption = findViewById<TextView>(R.id.btnOption)
        var signUp = Intent(this,SignupActivity::class.java)
        btnOption.setOnClickListener{
                startActivity(signUp)
        }
        progresssBar = findViewById(R.id.progress_bar)
    }

    override fun onStarted() {
        progresssBar?.visibility = View.VISIBLE
      toast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {

        loginResponse.observe(this, Observer {
            progresssBar?.visibility = View.INVISIBLE
            toast("login ${it}")
        })
    }

    override fun onFailure(message: String) {
        progresssBar?.visibility = View.INVISIBLE
        toast("Error $message")
    }
}
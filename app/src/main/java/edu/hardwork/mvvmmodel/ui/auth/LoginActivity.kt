package edu.hardwork.mvvmmodel.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import edu.hardwork.mvvmmodel.R
import edu.hardwork.mvvmmodel.databinding.ActivityLoginBinding
import edu.hardwork.mvvmmodel.utils.toast
import edu.hardwork.mvvmmodel.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity() ,AuthListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener= this

        var btnOption = findViewById<TextView>(R.id.btnOption)
        var signUp = Intent(this,SignupActivity::class.java)
        btnOption.setOnClickListener{
                startActivity(signUp)
        }
    }

    override fun onStarted() {
      toast("Login Started")
    }

    override fun onSuccess() {
        toast("Login Success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
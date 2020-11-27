package com.jessica.yourfavoritemovies.authentication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jessica.yourfavoritemovies.R
import com.jessica.yourfavoritemovies.authentication.viewmodel.AuthenticationViewModel
import com.jessica.yourfavoritemovies.home.view.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel: AuthenticationViewModel by lazy {
        ViewModelProvider(this).get(
            AuthenticationViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_login.setOnClickListener {
            val email = etv_email.text.toString()
            val password = etv_password.text.toString()

            //TODO - Implementar a verificação por do email e senha e realizar o login
        }

        tv_login_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    //TODO - Implementar os observers do viewmodel

    private fun navigateToHome(status: Boolean) {
        when {
            status -> {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(bt_login, message, Snackbar.LENGTH_LONG).show()
    }
}
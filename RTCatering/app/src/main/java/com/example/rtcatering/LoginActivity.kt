package com.example.rtcatering

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvBack = findViewById<TextView>(R.id.tvBack)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)

        btnLogin.setOnClickListener {
            loginUser()
        }

        tvBack.setOnClickListener {
            finish()
        }

        tvRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        tvForgotPassword.setOnClickListener {

            Toast.makeText(
                this,
                "Password recovery will be added later.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun loginUser() {

        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()

        if (email.isEmpty()) {
            etEmail.error = "Please enter your email address"
            etEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Please enter a valid email address"
            etEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Please enter your password"
            etPassword.requestFocus()
            return
        }

        Toast.makeText(
            this,
            "Login successful!",
            Toast.LENGTH_SHORT
        ).show()

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

        finish()
    }
}
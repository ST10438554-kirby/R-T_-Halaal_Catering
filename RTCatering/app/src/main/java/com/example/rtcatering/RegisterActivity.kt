package com.example.rtcatering

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvBack = findViewById<TextView>(R.id.tvBack)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        btnRegister.setOnClickListener {
            registerUser()
        }

        tvBack.setOnClickListener {
            finish()
        }

        tvLogin.setOnClickListener {
            openLogin()
        }
    }

    private fun registerUser() {

        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        // Check required fields

        if (firstName.isEmpty()) {
            etFirstName.error = "Please enter your first name"
            etFirstName.requestFocus()
            return
        }

        if (lastName.isEmpty()) {
            etLastName.error = "Please enter your last name"
            etLastName.requestFocus()
            return
        }

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

        if (phone.isEmpty()) {
            etPhone.error = "Please enter your phone number"
            etPhone.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Please enter a password"
            etPassword.requestFocus()
            return
        }

        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return
        }

        if (confirmPassword.isEmpty()) {
            etConfirmPassword.error = "Please confirm your password"
            etConfirmPassword.requestFocus()
            return
        }

        if (password != confirmPassword) {
            etConfirmPassword.error = "Passwords do not match"
            etConfirmPassword.requestFocus()
            return
        }

        // Temporary success message.
        // We will connect this to the REST API later.

        Toast.makeText(
            this,
            "Account details are valid!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun openLogin() {

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        finish()
    }
}
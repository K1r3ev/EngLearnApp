package com.example.englearnapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val button: Button = findViewById(R.id.btnNavigate)
        val editText: EditText = findViewById(R.id.usernameEditText)

        button.setOnClickListener {
            val username: String = editText.text.toString()
            sharedPreferences.edit().putString("username", username).apply()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        }
    }
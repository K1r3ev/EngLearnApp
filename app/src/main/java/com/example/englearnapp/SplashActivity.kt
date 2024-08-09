package com.example.englearnapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", null)


        android.os.Handler().postDelayed(
                {
                    if (username.isNullOrEmpty()) {
                        // Если username не введен, то открывается LoginActivity
                        val intent = Intent(this, LoginActivity::class.java)
                        finish()
                        startActivity(intent)
                    } else {
                        // Если username введен, то переход на MainActivity
                        val intent = Intent(this, MainActivity::class.java)
                        finish()
                        startActivity(intent)
                    }
                },3000)
        }
        }


package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity2 : AppCompatActivity() {
    private val dictionaryTitle = listOf(
        ("Greetings"),
        ("First day of School "),
        ("BirthDay "),
        ("Colors"),
        ("Numbers"),

        )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val index = intent.getIntExtra("index", -1) // Receive the index parameter
        if (index!= -1) {
            tvTitle.text = dictionaryTitle[index]
            android.os.Handler().postDelayed(
                {
                    val intent = Intent(this, GreetingsActivity::class.java)
                    finish()
                    startActivity(intent)
                }, 1500)
        } else {
            android.os.Handler().postDelayed(
                {
                    val intent = Intent(this, LearningActivity::class.java)
                    finish()
                    startActivity(intent)
                }, 1500)
        }
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
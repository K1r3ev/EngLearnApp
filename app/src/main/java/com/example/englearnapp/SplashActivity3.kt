package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_splash3)
        val tvTitle = findViewById<TextView>(R.id.tvTitle1)
        val title = intent.getStringExtra("title")
        if (title != null) {
            tvTitle.text = title
        }
            android.os.Handler().postDelayed(
                {
                    val intent = Intent(this, TrainerActivity::class.java)
                    finish()
                    startActivity(intent)
                }, 1500)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

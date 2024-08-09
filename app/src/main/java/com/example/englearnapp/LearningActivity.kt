package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityLearningBinding

class LearningActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLearningBinding
    private lateinit var tv2: TextView
    private val sharedPreferences by lazy { getSharedPreferences("SharedPref", MODE_PRIVATE) }
    private val storedUsername by lazy { sharedPreferences.getString("username", "") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLearningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        tv2 = findViewById<TextView>(R.id.tvProfile1)
        tv2.text = storedUsername // Set the text here

        binding.btnBegin.setOnClickListener {
            val intent = Intent(this@LearningActivity, BeginnerActivity::class.java)
            startActivity(intent)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
        binding.btnInter.setOnClickListener {
            val intent = Intent(this@LearningActivity, IntermediateActivity::class.java)
            startActivity(intent)
    }
        binding.btnAdvan.setOnClickListener {
            Toast.makeText(this, "You need complete a least beginner to start learning advanced", Toast.LENGTH_SHORT).show()
        }
}
}
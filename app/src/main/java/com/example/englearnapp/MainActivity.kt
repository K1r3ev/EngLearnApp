package com.example.englearnapp

import android.app.Activity
import android.app.ActivityManager
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnLearn.setOnClickListener {
            val intent = Intent(this, SplashActivity2::class.java)
            intent.putExtra("title", "Learning")
            startActivity(intent)
        }
        binding.btnTrain.setOnClickListener {

            val intent = Intent(this@MainActivity, SplashActivity3::class.java)
            intent.putExtra("title", "Trainer Words")
            startActivity(intent)
        }
        binding.btnStory.setOnClickListener {

            val intent = Intent(this@MainActivity, SelectActivity::class.java)
            intent.putExtra("title", "Trainer Words")
            startActivity(intent)
        }
        binding.tvMotivate.viewTreeObserver.addOnGlobalLayoutListener {
            val width = binding.tvMotivate.width
            val animation = TranslateAnimation(width.toFloat(), -width.toFloat(), 0f, 0f)
            animation.duration = 10000 // длительность анимации в миллисекундах
            animation.repeatCount = Animation.INFINITE // бесконечное повторение анимации
            binding.tvMotivate.startAnimation(animation)
        }
    }

    private fun enableEdgeToEdge() {
        // Enable edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowInsetsCompat.CONSUMED
        }
    }
}
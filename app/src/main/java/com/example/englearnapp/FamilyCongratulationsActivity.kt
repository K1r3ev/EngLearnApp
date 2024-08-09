package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityFamilyCongratulationsBinding
import com.example.englearnapp.databinding.ActivityFarmCongratulationsBinding

class FamilyCongratulationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFamilyCongratulationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFamilyCongratulationsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        }
    }


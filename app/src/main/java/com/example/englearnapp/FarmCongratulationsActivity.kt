package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityFarmCongratulationsBinding

class FarmCongratulationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFarmCongratulationsBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
            super.onCreate(savedInstanceState)
            binding = ActivityFarmCongratulationsBinding.inflate(layoutInflater)
            enableEdgeToEdge()

            setContentView(binding.root)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val button: Button = binding.btnContinueFarm
            button.setOnClickListener {
                val intent = Intent(this, BeginnerActivity::class.java)
                intent.putExtra("color2", R.drawable.shape_round_num_correct)
                startActivity(intent)
                finish()
            }
    }
}
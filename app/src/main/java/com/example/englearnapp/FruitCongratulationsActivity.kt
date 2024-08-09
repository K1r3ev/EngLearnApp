package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityFarmCongratulationsBinding
import com.example.englearnapp.databinding.ActivityFruitCongratulationsBinding

class FruitCongratulationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFruitCongratulationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitCongratulationsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = binding.btnContinueFruit
        button.setOnClickListener {
            val intent = Intent(this, BeginnerActivity::class.java)
            intent.putExtra("color3", R.drawable.shape_round_num_correct)
            finish()
            startActivity(intent)
        }
    }
}
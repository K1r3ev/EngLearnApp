package com.example.englearnapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityCongratulationsBinding

class CongratulationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCongratulationsBinding
    private val dictionaryName = listOf(
       ("FAMILY  LEVEL 4 completed"),
       ("FAMILY  LEVEL 5 completed "),
        ("FAMILY  LEVEL 6 completed "),
        ("FAMILY  LEVEL 7 completed"),
       ("FAMILY  LEVEL 8 completed"),

        )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        val view = binding.root
        val index = intent.getIntExtra("index", 0) // Receive the index parameter
        setContentView(view)
        enableEdgeToEdge()
        binding.tvTitle.text = dictionaryName[index]

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = binding.btnCont
        button.setOnClickListener {
            val intent = Intent(this, BeginnerActivity::class.java)
            intent.putExtra("color", R.drawable.shape_round_num_correct)
            finish()
            startActivity(intent)
        }
    }
}
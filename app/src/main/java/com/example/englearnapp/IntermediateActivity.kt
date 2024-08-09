package com.example.englearnapp

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityBeginnerBinding
import com.example.englearnapp.databinding.ActivityIntermediateBinding

class IntermediateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntermediateBinding
    private val sharedPreferences by lazy { getSharedPreferences("SharedPref", MODE_PRIVATE) }
    private lateinit var tv2: TextView
    private val storedUsername by lazy { sharedPreferences.getString("username", "") }
    private var currentConstraintLayoutId = 0
    private val storedText1 by lazy { sharedPreferences.getString("FirstsDay", "NEW LVL SOON") }
    private val storedText2 by lazy { sharedPreferences.getString("Colors", "NEW LVL SOON") }
    private val storedText3 by lazy { sharedPreferences.getString("Numbers", "NEW LVL SOON") }
    private val storedText4 by lazy { sharedPreferences.getString("Animal", "NEW LVL SOON") }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntermediateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv2 = findViewById(R.id.tvProfile)
        tv2.text = storedUsername

        val constraintLayout = findViewById<ConstraintLayout>(R.id.CL1)
        val constraintLayout1 = findViewById<ConstraintLayout>(R.id.CL2)
        val constraintLayout2 = findViewById<ConstraintLayout>(R.id.CL3)
        val constraintLayout3 = findViewById<ConstraintLayout>(R.id.CL4)

        binding.tvNameLvl.text = sharedPreferences.getString("FirstsDay", "NEW LVL SOON")
        binding.tvNameLvl3.text = sharedPreferences.getString("Colors", "NEW LVL SOON")
        binding.tvNameLvl4.text = sharedPreferences.getString("Numbers", "NEW LVL SOON")
        binding.tvNameLvl5.text = sharedPreferences.getString("Animal", "NEW LVL SOON")

        val color = intent.getIntExtra("color", R.drawable.shape_round) // получаем цвет
        constraintLayout.setBackgroundResource(color)
        val color2 = intent.getIntExtra("color2", R.drawable.shape_round) // получаем цвет
        constraintLayout1.setBackgroundResource(color2)
        val color3 = intent.getIntExtra("color3", R.drawable.shape_round) // получаем цвет
        constraintLayout2.setBackgroundResource(color3)
        val color4 = intent.getIntExtra("color4", R.drawable.shape_round) // получаем цвет
        constraintLayout3.setBackgroundResource(color4)
        when {
            color != R.drawable.shape_round -> {
                binding.CL1.setBackgroundResource(color)
                binding.tvNameLvl.text = "First Day of School"
                sharedPreferences.edit().putString("FirstsDay", "First Day of School").apply()
            }
            color2 != R.drawable.shape_round -> {
                binding.CL2.setBackgroundResource(color2)
                binding.tvNameLvl3.text = "Birthday"
                sharedPreferences.edit().putString("Colors", "Birthday").apply()
            }
            color3 != R.drawable.shape_round -> {
                binding.CL3.setBackgroundResource(color3)
                binding.tvNameLvl4.text = "Colors"
                sharedPreferences.edit().putString("Numbers", "Colors").apply()
            }
            color4 != R.drawable.shape_round -> {
                binding.CL4.setBackgroundResource(color4)
                binding.tvNameLvl5.text = "Numbers"
                sharedPreferences.edit().putString("Animal", "Numbers").apply()
            }
        }



        binding.btnStart.setOnClickListener {
            val intent = Intent(this, GreetingsActivity::class.java)
            intent.putExtra("index", 0) // Add this line
            finish()
            startActivity(intent)
        }
        binding.btnStart1.setOnClickListener {
            val intent = Intent(this, GreetingsActivity::class.java)
            intent.putExtra("index", 1) // Add this line
            finish()
            startActivity(intent)
        }
        binding.btnStart3.setOnClickListener {
            val intent = Intent(this, GreetingsActivity::class.java)
            intent.putExtra("index", 2) // Add this line
            finish()
            startActivity(intent)
        }
            binding.btnStart4.setOnClickListener {
                val intent = Intent(this, GreetingsActivity::class.java)
                intent.putExtra("index", 3) // Add this line
                finish()
                startActivity(intent)
            }
                binding.btnStart5.setOnClickListener {
                    val intent = Intent(this, GreetingsActivity::class.java)
                    intent.putExtra("index", 4) // Add this line
                    finish()
                    startActivity(intent)
                }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


        }




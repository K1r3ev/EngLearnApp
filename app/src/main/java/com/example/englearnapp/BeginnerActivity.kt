package com.example.englearnapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityBeginnerBinding
import com.example.englearnapp.databinding.ActivityLearningBinding

class BeginnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBeginnerBinding
    private lateinit var tv2: TextView
    private var currentConstraintLayoutId = 0
    private val sharedPreferences by lazy { getSharedPreferences("SharedPref", MODE_PRIVATE) }
    private val storedUsername by lazy { sharedPreferences.getString("username", "") }
    private val storedText1 by lazy { sharedPreferences.getString("Animals", "NEW LVL SOON") }
    private val storedText2 by lazy { sharedPreferences.getString("Fruits", "NEW LVL SOON") }
    private val storedText3 by lazy { sharedPreferences.getString("Family", "NEW LVL SOON") }
    private val storedText4 by lazy { sharedPreferences.getString("BodyParts", "NEW LVL SOON") }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityBeginnerBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        tv2 = findViewById(R.id.tvProfile)
        tv2.text = storedUsername

        val constraintLayout = findViewById<ConstraintLayout>(R.id.CL1)
        val constraintLayout1 = findViewById<ConstraintLayout>(R.id.CL2)
        val constraintLayout2 = findViewById<ConstraintLayout>(R.id.CL3)
        val constraintLayout3 = findViewById<ConstraintLayout>(R.id.CL4)

        binding.tvNameLvl.text = sharedPreferences.getString("Animals", "NEW LVL SOON")
        binding.tvNameLvl3.text = sharedPreferences.getString("Fruits", "NEW LVL SOON")
        binding.tvNameLvl4.text = sharedPreferences.getString("Family", "NEW LVL SOON")
        binding.tvNameLvl5.text = sharedPreferences.getString("BodyParts", "NEW LVL SOON")

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
                binding.tvNameLvl.text = "Animals"
                sharedPreferences.edit().putString("Animals", "Animals").apply()
            }
            color2 != R.drawable.shape_round -> {
                binding.CL2.setBackgroundResource(color2)
                binding.tvNameLvl3.text = "Fruits"
                sharedPreferences.edit().putString("Fruits", "Fruits").apply()
            }
            color3 != R.drawable.shape_round -> {
                binding.CL3.setBackgroundResource(color3)
                binding.tvNameLvl4.text = "Family"
                sharedPreferences.edit().putString("Family", "Family").apply()
            }
            color4 != R.drawable.shape_round -> {
                binding.CL4.setBackgroundResource(color4)
                binding.tvNameLvl5.text = "BodyParts"
                sharedPreferences.edit().putString("BodyParts", "BodyParts").apply()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStart.setOnClickListener {
            val intent = Intent(this@BeginnerActivity, ClassroomActivity::class.java)
            finish()
            startActivity(intent)
        }
        binding.btnStart1.setOnClickListener {
            val intent = Intent(this@BeginnerActivity, FarmActivity::class.java)
            finish()
            startActivity(intent)
        }
        binding.btnStart3.setOnClickListener {
            val intent = Intent(this@BeginnerActivity, FruitsActivity::class.java)
            finish()
            startActivity(intent)
        }
        binding.btnStart4.setOnClickListener {
            val intent = Intent(this@BeginnerActivity, FamilyActivity::class.java)
            finish()
            startActivity(intent)

        }
        binding.btnStart5.setOnClickListener {
            val intent = Intent(this@BeginnerActivity, BodyActivity::class.java)
            finish()
            startActivity(intent)
        }

    }

        }



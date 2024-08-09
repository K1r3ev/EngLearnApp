package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityCongratulations1Binding
import com.example.englearnapp.databinding.ActivityCongratulationsBinding

class CongratulationsActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityCongratulations1Binding
    private val dictionaryName = listOf(
        ("GREETINGS LEVEL 6 completed"),
        ("FIRST DAY OF THE SCHOOL LEVEL 7 completed "),
        ("BIRTHDAY LEVEL 8 completed "),
        ("COLORS LEVEL 9 completed"),
        ("NUMBERS LEVEL 10 completed"),

        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulations1Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        val index = intent.getIntExtra("index", 0) // Receive the index parameter
        setContentView(binding.root)
        binding.tvTitle.text = dictionaryName[index]
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = binding.btnCont
        button.setOnClickListener {
            val intent = Intent(this, IntermediateActivity::class.java)
            when (index) {
                0 -> intent.putExtra("color", R.drawable.shape_round_num_correct)
                1 -> intent.putExtra("color2", R.drawable.shape_round_num_correct)
                2 -> intent.putExtra("color3", R.drawable.shape_round_num_correct)
                3 -> intent.putExtra("color4", R.drawable.shape_round_num_correct)
                4 -> intent.putExtra("color5", R.drawable.shape_round_num_correct) }
            finish()
            startActivity(intent)
    }
}
}
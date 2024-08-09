package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.englearnapp.databinding.ActivityClassroomBinding
import com.example.englearnapp.databinding.ActivityFarmBinding

class FarmActivity : AppCompatActivity() {
    var selectedImageIndex = 0
    var selectedWordIndex = 0
    var selectedEngWordIndex = 0
    private lateinit var binding: ActivityFarmBinding


    val imageList = listOf(
        R.drawable.cow,
        R.drawable.dog,
        R.drawable.cat,
        R.drawable.bird,
        R.drawable.giraffe,
        R.drawable.croco,
        R.drawable.duck,
        R.drawable.pig,
        R.drawable.pig
    )
    val WordList = listOf(
        "Корова",
        "Собака",
        "Кошка,кот",
        "Птица",
        "Жираф",
        "Крокодил",
        "Утка",
        "Свинья",
        "Свинья"




    )
    val EngWordList = listOf(
        "COW",
        "DOG",
        "CAT",
        "BIRD",
        "GIRAFFE",
        "CROCODILE",
        "DUCK",
        "PIG",
        "PIG"

    )
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityFarmBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        selectedImageIndex = 0
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnUp.setOnClickListener {
            updateImage()
            updateHint()
            updateWord()
        }


        binding.ivCard.setOnClickListener {
            rotateImageView()
            toggleTextView()
            toggleImageView()
            rotateClear()
        }

    }

    private fun updateImage() {

        selectedImageIndex = (selectedImageIndex + 1) % imageList.size
        if (selectedImageIndex == 0) {
            intent = Intent(this@FarmActivity, FarmCongratulationsActivity::class.java)
            finish()
            startActivity(intent)
        }
        else {
            binding.ivCard.setImageResource(imageList[selectedImageIndex - 1])
        }
    }
    private fun updateHint(){

        binding.ivRemind.setText(WordList[selectedWordIndex])
        selectedWordIndex = (selectedWordIndex + 1 ) % WordList.size

    }
    private fun updateWord(){

        binding.tvWord.setText(EngWordList[selectedEngWordIndex])
        selectedEngWordIndex = (selectedEngWordIndex + 1 ) % EngWordList.size
    }



    private fun rotateImageView() {
        val rotation = if (binding.ivCard.rotationY == 0f) 180f else 0f
        binding.ivCard.animate().rotationY(rotation).duration = 200
    }

    private fun rotateClear() {
        val rotation = if (binding.ivCardClear.rotationY == 0f) 180f else 0f
        binding.ivCardClear.animate().rotationY(rotation).duration = 200
    }

    private fun toggleTextView() {
        if (binding.ivRemind.visibility == View.GONE) {
            binding.ivRemind.visibility = View.VISIBLE
        } else {
            binding.ivRemind.visibility = View.GONE
        }
    }


    private fun toggleImageView() {
        if (binding.ivCardClear.visibility == View.GONE) {
            binding.ivCardClear.visibility = View.VISIBLE
        } else {
            binding.ivCardClear.visibility = View.GONE
        }
    }

}
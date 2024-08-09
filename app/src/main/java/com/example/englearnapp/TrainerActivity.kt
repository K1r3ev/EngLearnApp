package com.example.englearnapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.englearnapp.databinding.ActivityTrainerBinding

class TrainerActivity : AppCompatActivity() {
    private var _binding: ActivityTrainerBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTrainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trainer = LearnWordsTrainer()
        showNextQuestion(trainer)

        with(binding) {
            btnContinue.setOnClickListener {
                layoutResult.isVisible = false
                markAnswerNeutral(tvVariantNumber1, tvVariantValue1)
                markAnswerNeutral( tvVariantNumber2, tvVariantValue2)
                markAnswerNeutral( tvVariantNumber3, tvVariantValue3)
                markAnswerNeutral( tvVariantNumber4, tvVariantValue4)
                showNextQuestion(trainer)
            }

            btnSkip.setOnClickListener {
                showNextQuestion(trainer)
            }
        }
    }

    private fun showNextQuestion(trainer: LearnWordsTrainer) {
        val firstQuestion: Question? = trainer.getNextQuestion()
        with(binding) {
            if (firstQuestion == null || firstQuestion.variants.size < NUMBER_OF_ANSWERS) {
                tvQuestionWord.isVisible = false
                layoutVariants.isVisible = false
                btnSkip.text = "Complete"
            } else {
                btnSkip.isVisible = true
                tvQuestionWord.isVisible = true
                tvQuestionWord.text = firstQuestion.correctAnswer.original

                tvVariantValue1.text = firstQuestion.variants[0].translate
                tvVariantValue2.text = firstQuestion.variants[1].translate
                tvVariantValue3.text = firstQuestion.variants[2].translate
                tvVariantValue4.text = firstQuestion.variants[3].translate

                layoutAnswer1.setOnClickListener {
                    if (trainer.checkAnswer(0)) {
                        markAnswerCorrect( tvVariantNumber1, tvVariantValue1)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong( tvVariantNumber1, tvVariantValue1)
                        showResultMessage(false)
                    }
                }
                layoutAnswer2.setOnClickListener {
                    if (trainer.checkAnswer(1)) {
                        markAnswerCorrect( tvVariantNumber2, tvVariantValue2)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong( tvVariantNumber2, tvVariantValue2)
                        showResultMessage(false)
                    }
                }
                layoutAnswer3.setOnClickListener {
                    if (trainer.checkAnswer(2)) {
                        markAnswerCorrect(tvVariantNumber3, tvVariantValue3)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong( tvVariantNumber3, tvVariantValue3)
                        showResultMessage(false)
                    }
                }
                layoutAnswer4.setOnClickListener {
                    if (trainer.checkAnswer(3)) {
                        markAnswerCorrect( tvVariantNumber4, tvVariantValue4)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong( tvVariantNumber4, tvVariantValue4)
                        showResultMessage(false)
                    }
                }
            }
        }
    }

    private fun markAnswerNeutral(

        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        tvVariantNumber.apply {
            background = ContextCompat.getDrawable(
                this@TrainerActivity,
                R.drawable.shape_round_num,
            )
            setTextColor(
                ContextCompat.getColor(
                    this@TrainerActivity,
                    R.color.white,
                )
            )
        }

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@TrainerActivity,
                R.color.black
            )
        )
    }

    private fun markAnswerWrong(
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {


        tvVariantNumber.background = ContextCompat.getDrawable(
            this@TrainerActivity,
            R.drawable.shape_round_num_wrong
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@TrainerActivity,
                R.color.white
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@TrainerActivity,
                R.color.wrongAnswerColor)
        )

    }

    private fun markAnswerCorrect(
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        tvVariantNumber.background = ContextCompat.getDrawable(
            this@TrainerActivity,
            R.drawable.shape_round_num_correct
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@TrainerActivity,
                R.color.white
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@TrainerActivity,
                R.color.correctAnswerColor
            )
        )

    }

    private fun showResultMessage(isCorrect: Boolean) {
        val color: Int
        val messageText: String
        val resultIconResource: Int
        if (isCorrect) {
            color = ContextCompat.getColor(this, R.color.correctAnswerColor)
            messageText = "Correct!" // TODO get from string resources
        } else {
            color = ContextCompat.getColor(this, R.color.wrongAnswerColor)
            messageText = "Incorrect!" // TODO get from string resources
        }

        with(binding) {
            btnSkip.isVisible = false
            layoutResult.isVisible = true
            btnContinue.setTextColor(color)
            layoutResult.setBackgroundColor(color)
            tvResultMessage.text = messageText
        }
    }

}
package com.example.englearnapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GreetingsActivity : AppCompatActivity() {
    private lateinit var tvTitleOfObject: TextView
    private lateinit var tvObject: TextView
    private lateinit var tvTitleOfStory: TextView
    private lateinit var tvStory: TextView
    private lateinit var tvKey: TextView
    private lateinit var tvExpres: TextView
    private lateinit var tvExpresText: TextView
    private lateinit var tvTitleOfVocubulary: TextView
    private lateinit var tvVocubulary: TextView
    private lateinit var btnUp: Button

    private val dictionaryObject = listOf(
        Object("-To teach basic greetings & self-indrodutions in English. This lesson will teach kids to introduce themselves and greet people the first time they meet"),
        Object("-This lesson will help kids review basic greetings and also teach kids how to introduce friends. It will also teach learnser how to express a need."),
        Object("-This lesson will teach kids how to ask questions about agee and give information about themselves relating to their age."),
        Object("-This lesson aims to help kids use colors as adjectives to describe nouns"),
        Object("-This lesson will emphasize the question format 'How many...?' which is used when asking for a numeric response in English"),
    )
    private val dictionaryStory = listOf(
        Story("Bob's Family has just moved into'Freddie's Ville' - the town where characters live. Freddie and Lisa go over to say hi to the new neighbors."),
        Story("it is Bob's first day at school. He lost in the corridor, trying to find his class. Freddie shows up and offers help. In the end, Bob in introduced to other classmates ."),
        Story("It;s Freddie's birthday and he has invited his friends, Bob, and Sally to his party.Mom has made a beautiful cake with six candles on them.The kids put on their party hats and sit around the table.A conversation about age begins."),
        Story("Freddie, Lisa and Friends are at the orchard where they see fruits of various color.They begin a chat on the different colors of the fruits and their favorite colors.Lisa learns that orange is not yellow and that orange is a color and fruit.Bob likes green; Sally likes purpule.Lisa's favorite color is green."),
        Story("Freddie and Lisa are by the lake when suddenly many ducks come swimming across.They try to count the ducks as they swim by."),

    )
    private val dictionaryExpres = listOf(
        Expres("My name is Lisa/I'm Lisa." +
                "  My name is Freddie/ I'm Freddie. CONTRACTIONS: I'm Bob/I am Bob." +
                "  I'm Freddie/ I am Freddie" +
                "QUESTION FORMAT" +
                "What is...?/ What is your name?" +
                "What's....?/ What's your name?" +
                "    Adjective & verbs in greetins:" +
                "Nice(adj.)" +
                "To meet(Verb)"),
        Expres("Good morinng, Bob" +
                "  How are you today?" +
                "  I'm fine, thanks." +
                "  Do you need any help?" +
                "  I'm looking for Class 3A" +
                "  This is my friend,Bob" +
                "  Bob is our new classmate"),
        Expres("Are you six years old, Freddie?" +
                "   Yes, I am" +
                "  How old are you, Bob?" +
                "  I'm almost six." +
                "  How old is Lisa?" +
                "  She's four." +
                "  You are four."),
        Expres("This peach is pink." +
                "What's your favorite color?" +
                "I like green" +
                "Sally likes purpule." +
                "Those orange are now yellow.They are orange"),
        Expres("How many ducks can see you?" +
                "I can see many ducks." +
                "let's count them." +
                "There are seven ducks."),

    )
    private val dictionaryVocubulary = listOf(
       Vocubulary("name, nice, meet, you, your, my, Proper Nouns: Freddie, Bob, Lisa "),
        Vocubulary("Classmate, looking, class, morning, same, friend, today, help, new"),
        Vocubulary("Numbers 1-10, old, almost, four, six, you, she,years"),
        Vocubulary("yellow, red, orange, green, purpule, pink, like, favorite, color, apple, peach"),
        Vocubulary("numbers, how, many, one,two, three, four, five,six,seven,eight, nine, ten, ducks,peaches, dishes, buses, feet, mine."),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greetings)

        val index = intent.getIntExtra("index", 0) // Receive the index parameter
        tvTitleOfObject = findViewById(R.id.tvTitleOfObject)
        tvObject = findViewById(R.id.tvObject)
        tvTitleOfStory = findViewById(R.id.tvTitleOfStory)
        tvStory = findViewById(R.id.tvStory)
        tvKey = findViewById(R.id.tvKey)
        tvExpres = findViewById(R.id.tvExpres)
        tvExpresText = findViewById(R.id.tvExpresText)
        tvTitleOfVocubulary = findViewById(R.id.tvTitleOfVocubulary)
        tvVocubulary = findViewById(R.id.tvVocubulary)
        btnUp = findViewById(R.id.btnUp)

        tvObject.text = dictionaryObject[index].Object
        tvStory.text = dictionaryStory[index].Story
        tvExpresText.text = dictionaryExpres[index].Expres
        tvVocubulary.text = dictionaryVocubulary[index].Vocubulary


        btnUp.setOnClickListener {
            tvTitleOfObject.visibility = View.GONE
            tvObject.visibility = View.GONE
            tvTitleOfStory.visibility = View.GONE
            tvStory.visibility = View.GONE

            tvKey.visibility = View.VISIBLE
            tvExpres.visibility = View.VISIBLE
            tvExpresText.visibility = View.VISIBLE
            tvTitleOfVocubulary.visibility = View.VISIBLE
            tvVocubulary.visibility = View.VISIBLE

            tvExpresText.text = dictionaryExpres[index].Expres
            tvVocubulary.text = dictionaryVocubulary[index].Vocubulary
            btnUp.text = "END"
            btnUp.setOnClickListener {
                // Start a new activity here
                val intent = Intent(this, CongratulationsActivity1::class.java)
                intent.putExtra("index", index) // Add this line
                finish()
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
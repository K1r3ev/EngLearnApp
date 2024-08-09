package com.example.englearnapp

private var viewedImagesCount = 0


data class Word (
    val original: String,
    val translate: String,
    var learned: Boolean = false,
)

data class Question(
    val variants: List<Word>,
    val correctAnswer: Word,
)
class LearnWordsTrainer {

    private val dictionary = listOf(
        Word("Sit down", "Сесть"),
        Word("Stand Up", "Встать"),
        Word("Hands", "Руки"),
        Word("clap", "Хлопок"),
        Word("Feet", "Нога"),
        Word("stamp", "Штамп"),
        Word("Up", "Вверх"),
        Word("Down", "Вниз"),
        Word("write", "Писать"),
        Word("read", "Читать"),
        Word("Towel", "Полотенце"),
        Word("Clap your hands", "Хлопать в ладоши"),
        Word("Pencil", "Карандаш"),
        Word("Ruler", "Линейка"),
        Word("Paper", "Бумага"),
        Word("Eraser", "Ластик"),
        Word("Book", "Книга"),
        Word("Name", "Имя"),
        Word("Red", "Красный"),
        Word("Pink", "Розовый"),
        Word("Orange", "Оранжевый"),
        Word("Blue", "Синий"),
        Word("Apple", "Яблоко"),
        Word("Carrot", "Морковь"),
        Word("Car", "Машина")

    )

    private var currentQuestion: Question? = null

    fun getNextQuestion(): Question? {

        val notLearnedList = dictionary.filter { !it.learned }
        if (notLearnedList.isEmpty()) return null

        val questionWords =
            if (notLearnedList.size < NUMBER_OF_ANSWERS) {
                val learnedList = dictionary.filter { it.learned }.shuffled()
                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + learnedList
                    .take(NUMBER_OF_ANSWERS - notLearnedList.size)
            } else {
                notLearnedList.shuffled().take(NUMBER_OF_ANSWERS)
            }.shuffled()

        val correctAnswer: Word = questionWords.random()

        currentQuestion = Question(
            variants = questionWords,
            correctAnswer = correctAnswer,
        )
        return currentQuestion
    }

    fun checkAnswer(userAnswerIndex: Int?): Boolean {

        return currentQuestion?.let {

            val correctAnswerId = it.variants.indexOf(it.correctAnswer)
            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true
                true
            } else {
                false
            }
        } ?: false
    }
}

const val NUMBER_OF_ANSWERS: Int = 4
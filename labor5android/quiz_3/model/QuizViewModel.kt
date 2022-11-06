package com.example.quiz_3.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    val questions: MutableList<Questions> = com.example.quiz_3.model.questions;
    var numCorrect: Int = 0
    private val numberOfQuestions: Int = 5
    var itQuestion: MutableIterator<Questions> = doQuiz(numberOfQuestions).iterator()
    var currentQuestion: MutableLiveData<Pair<Questions?, Boolean>> =
        MutableLiveData<Pair<Questions?, Boolean>>()

    init {
        getNextQuestion()
    }

    private fun randomizeQuestions() {
        questions.forEach { q -> q.answers.shuffle() }
        questions.shuffle()
    }

    fun doQuiz(numOfQuestions: Int): MutableList<Questions> {
        this.randomizeQuestions()
        val questionsToBeShown = questions.subList(0, numOfQuestions);
        return questionsToBeShown
    }

    fun getNextQuestion() {
        if (itQuestion.hasNext()) {
            currentQuestion.value = itQuestion.next() to !itQuestion.hasNext()
        }
    }

    fun resetQuiz() {
        numCorrect = 0
        itQuestion = doQuiz(5).iterator()
    }
}
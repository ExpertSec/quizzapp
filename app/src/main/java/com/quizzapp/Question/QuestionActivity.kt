package com.quizzapp.Question

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.quizzapp.Question.Model.QuestionModel
import com.quizzapp.ui.theme.QuizzAppTheme

class QuestionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val questionList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("list", QuestionModel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableArrayListExtra("list")
        } ?: emptyList()

        setContent {
            QuizzAppTheme {
                QuestionScreen(
                    question = questionList,
                    onFinish = { finish() },
                    onBackClick = { finish() }
                )
            }
        }
    }
}
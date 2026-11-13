package com.quizzapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quizzapp.Dashboard.screens.MainScreen
import com.quizzapp.Question.Model.QuestionModel
import com.quizzapp.Question.QuestionActivity
import com.quizzapp.ui.theme.QuizzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizzAppTheme {
                MainScreen(onSinglePlayerClick = {
                    val intent = Intent(this, QuestionActivity::class.java)
                    intent.putParcelableArrayListExtra("list", ArrayList(QuestionList()))
                    startActivity(intent)
                }, onBoardClick = {})
            }
        }
    }
    private fun QuestionList() : List<QuestionModel> {
        return listOf(
            QuestionModel(
                id = 1,
                question = "hukum ohm menjelaskan?",
                answer1 = "total arus yang masuk ke percabangan",
                answer2 = "total hambatan yang masuk ke percabangan",
                answer3 = "total tegangan yang masuk ke percabangan",
                answer4 = "hubungan antara daya hambatan tegangan dan arus",
                correctAnswer = "hubungan antara daya hambatan tegangan dan arus",
                score = 10,
                picPath = null,
                clickedAnswer = null
            )
        )
    }
}


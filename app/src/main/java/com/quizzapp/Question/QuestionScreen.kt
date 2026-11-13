package com.quizzapp.Question

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.RotateRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quizzapp.Question.Model.QuestionModel
import com.quizzapp.Question.Model.QuestionUiState
import com.quizzapp.Question.component.AnswerItem

@Composable

fun QuestionScreen(question : List<QuestionModel>, onFinish : (finalScore : Int) -> Unit, onBackClick : () -> Unit){
    var state by remember {
        mutableStateOf(QuestionUiState(question = question))
    }
    val currentQuestion = state.question.getOrNull(state.currentIndex) ?: return
    var selectedAnswer = currentQuestion.clickedAnswer
    val context = LocalContext.current
    val imageResId = remember(currentQuestion.picPath) {
        if (!currentQuestion.picPath.isNullOrEmpty()) {
            context.resources.getIdentifier(
                currentQuestion.picPath,
                "drawable",
                context.packageName
            )
        } else 0
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC0BFBF))
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth().padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onBackClick() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
                }
                Spacer(Modifier.width(16.dp))
                Text("Single Player", fontSize = 20.sp, color = Color(0xFF000C50), fontWeight = FontWeight.Bold)
            }
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Question ${state.currentIndex + 1}/${state.question.size}", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                IconButton(onClick = {
                    if (state.currentIndex > 0) {
                        selectedAnswer = null
                        state = state.copy(currentIndex = state.currentIndex - 1)
                    }
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = "back")
                }
                IconButton(onClick = {
                    if (state.currentIndex == state.question.size - 1) {
                        onFinish(state.score)
                    } else {
                        selectedAnswer = null
                        state = state.copy(currentIndex = state.currentIndex + 1)
                    }
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "next", Modifier.size(36.dp))
                }
            }
        }
        item {
            LinearProgressIndicator(
                progress = (state.currentIndex + 1) / state.question.size.toFloat(),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).height(14.dp).clip(
                    RoundedCornerShape(50)
                ),
                color = Color(0xFFF37521), trackColor = Color(0xFFE7E4E4)
            )
        }
        item {
            Text(text = currentQuestion.question ?: "", fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(all = 24.dp))
        }
        if (imageResId != 0) {
            item {
                Image(
                    painter = painterResource(imageResId), contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
        itemsIndexed(
            listOf(
                currentQuestion.answer1?:"",
                currentQuestion.answer2?:"",
                currentQuestion.answer3?:"",
                currentQuestion.answer4?:"",
            )
        ){index, answerText ->
            val answerLetter = listOf("a", "b", "c", "d")[index]
            val isCorrect = selectedAnswer != null && currentQuestion.correctAnswer == selectedAnswer
            val isWrong = selectedAnswer == answerLetter && !isCorrect
            AnswerItem(
                text = answerText,
                isCorrect = isCorrect,
                isSelected = selectedAnswer != null
            ) {
                val updatedQuestion = state.question.toMutableList()
                val updateQuestion = updatedQuestion[state.currentIndex].copy(clickedAnswer = answerLetter)
                updatedQuestion[state.currentIndex] = updateQuestion
                val scoreAdd = if(answerLetter == updateQuestion.correctAnswer) 5 else 0
                state = state.copy(
                    question = updatedQuestion,
                    score = state.score + scoreAdd
                )


            }

        }
        item {
            Spacer(Modifier.height(32.dp))
        }
        }
    }


@Composable
@Preview
fun QuestionScreenPreview(){
    val question = listOf<QuestionModel>(
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
    QuestionScreen(
        question = question,
        // Replaced TODO() with an empty lambda to avoid NotImplementedError during preview rendering
        onFinish = { }
    ) { }
}
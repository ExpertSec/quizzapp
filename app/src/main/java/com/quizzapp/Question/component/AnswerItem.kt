package com.quizzapp.Question.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerItem(
    text : String,
    isCorrect : Boolean = false,
    isWrong : Boolean = false,
    isSelected : Boolean = false,
    onClick : () -> Unit
){
    val backgroundColor = when{
        isCorrect -> Color.Green
        isWrong -> Color.Red
        else -> Color.White
    }
    val textColor = if(isCorrect || isWrong) Color.White else Color.Black
    val icon = when{
        isCorrect -> Icons.Filled.Check
        isWrong -> Icons.Default.Close
        else -> null
    }
    Box(
        Modifier.fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable(enabled = !isSelected){onClick()},
        contentAlignment = Alignment.CenterStart
    ){
        Row(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, fontSize = 16.sp, color = textColor, modifier = Modifier.weight(1f))
            icon?.let {
                Icon(imageVector = it, contentDescription = null, tint = Color.Unspecified,modifier = Modifier.size(24.dp))
            }
        }
    }
}
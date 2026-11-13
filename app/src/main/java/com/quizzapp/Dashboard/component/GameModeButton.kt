package com.quizzapp.Dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonalInjury
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quizzapp.R
import java.nio.file.WatchEvent

@Composable
fun GameMadeButtons(onSinglePlayerClick : () -> Unit={}){
    Row(modifier = Modifier.fillMaxWidth().height(145.dp).padding(horizontal = 24.dp), horizontalArrangement = Arrangement.SpaceBetween){
    GameButton(
        backgroundColor = R.color.teal_200,
        IconRes = Icons.Filled.Add,
        text = "Create Quizz",
        modifier = Modifier.weight(1f)
    )
        Spacer(Modifier.width(12.dp))
        GameButton(
        backgroundColor = R.color.purple_200,
        IconRes = Icons.Filled.Person,
        text = "Single Player",
        modifier = Modifier.weight(1f),
            onClick = onSinglePlayerClick
    )
        Spacer(Modifier.width(12.dp))
        GameButton(
        backgroundColor = R.color.teal_700,
        IconRes = Icons.Filled.PersonalInjury,
        text = "Multi Player",
        modifier = Modifier.weight(1f)
    )
    }
}



@Composable
fun GameButton(backgroundColor : Int,IconRes : ImageVector, text : String,onClick : (() -> Unit)?=null, modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxHeight().clickable(enabled = onClick != null){onClick?.invoke()}.clip(
        RoundedCornerShape(10.dp)
    ).background(Color(0xFFC0C0C0)).padding(all = 8.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Icon(imageVector = IconRes, contentDescription = null, Modifier.size(64.dp))
        Spacer(Modifier.height(24.dp))
        Text(text = text, color = Color.White, textAlign = TextAlign.Center, fontSize = 16.sp)
    }
}
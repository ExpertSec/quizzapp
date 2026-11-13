package com.quizzapp.Dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun CategoryGrid() {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            CategoryCard(
                "Science",
                iconRes = Icons.Filled.Science,
                Modifier.weight(1f).padding(start = 24.dp, end = 12.dp, top = 16.dp),
                color = Color(
                    0xFF22B4CE
                )
            )
            CategoryCard(
                "History",
                iconRes = Icons.Filled.History,
                Modifier.weight(1f).padding(start = 12.dp, end = 24.dp, top = 16.dp),
                color = Color(
                    0xFFC96417
                )
            )
        }
        Spacer(Modifier.padding(top = 8.dp))
        Row(Modifier.fillMaxWidth()) {
            CategoryCard(
                "Sport",
                iconRes = Icons.Filled.SportsSoccer,
                Modifier.weight(1f).padding(start = 24.dp, end = 12.dp, top = 16.dp),
                color = Color(
                    0xFF22B4CE
                )
            )
            CategoryCard(
                "Art",
                iconRes = Icons.Filled.Brush,
                Modifier.weight(1f).padding(start = 12.dp, end = 24.dp, top = 16.dp),
                color = Color(
                    0xFFC96417
                )
            )
        }
    }
}
@Composable
fun CategoryCard(title: String, iconRes : ImageVector, modifier : Modifier = Modifier, color : Color){
    Row(
        modifier = modifier
            .height(55.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFFFFFFF))
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = iconRes, contentDescription = null, tint = color, modifier = Modifier.size(34.dp))
        Spacer(Modifier.width(16.dp))
        Text(text = title, fontSize = 17.sp, fontWeight = FontWeight.Bold)
    }
}
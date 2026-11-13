package com.quizzapp.Dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.quizzapp.R

@Composable
fun Banner(){
    Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = null,
        contentScale = ContentScale.FillWidth
        , modifier = Modifier
            .fillMaxWidth()
        .padding(24.dp))
}




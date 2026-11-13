package com.quizzapp.Dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quizzapp.R
import java.nio.file.WatchEvent

@Composable
fun TopUserSection(){
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp, horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Profile", Modifier.size(24.dp))
        Spacer(Modifier.width(16.dp))
        Text("Hello, Arch", fontSize = 20.sp,modifier =  Modifier.weight(1f))
        Row(modifier = Modifier.height(40.dp).background(Color(0xFF004391),shape = RoundedCornerShape(10.dp)).padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "coin", modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(16.dp))
            Text("100", color = Color.White, fontSize = 16.sp)

        }
    }
}
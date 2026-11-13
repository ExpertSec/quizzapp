package com.quizzapp.Dashboard.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quizzapp.Dashboard.component.Banner
import com.quizzapp.Dashboard.component.BottomNavigationBar
import com.quizzapp.Dashboard.component.CategoryGrid
import com.quizzapp.Dashboard.component.CategoryHeader
import com.quizzapp.Dashboard.component.GameMadeButtons
import com.quizzapp.Dashboard.component.TopUserSection

@Composable
fun MainScreen(onSinglePlayerClick : () -> Unit = {}, onBoardClick : () -> Unit = {}){
    val scrollState = rememberScrollState()
    var selectedItem by remember { mutableStateOf(0) }
//    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFD0D0D0))){
        Scaffold(containerColor = Color(0xFFE1E1E1),bottomBar = {BottomNavigationBar(
            selectedItem = selectedItem,
            onItemSelected = {itemId ->
                selectedItem = itemId
            }
        )}) {paddingValues ->
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState).padding(paddingValues)) {
TopUserSection()
            Spacer(Modifier.height(16.dp))
            GameMadeButtons(onSinglePlayerClick)
            Spacer(Modifier.height(32.dp))
            CategoryHeader()
            CategoryGrid()
            Banner()
        }
    }
}


@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
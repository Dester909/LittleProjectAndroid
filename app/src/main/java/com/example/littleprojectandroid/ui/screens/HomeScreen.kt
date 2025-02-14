package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ){
        Text("Home Screen")
        Button(
            onClick = {navController.navigate("MainMenu")},
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Main Menu Screen")
        }
        Button(
            onClick = {navController.navigate("ScreenTest")},
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Screen Test")
        }
    }

}



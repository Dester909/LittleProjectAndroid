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
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Text("main menu")
        Button(
            onClick = { navController.navigate("HomeScreen") },
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Home Screen")
        }
        Button(
            onClick = { navController.navigate("ScreenTest") },
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Screen Test")
        }
        Button(
            onClick = { navController.navigate("NetflixScreen") },
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to NetflixScreen")
        }
        Button(
            onClick = { navController.navigate("componentsScreen") },
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Components Screen")
        }
    }
}
package com.example.littleprojectandroid.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("AppScreen")
        }) {
            Text("Ir a AppScreen")
        }

        Button(onClick = {
            navController.navigate("biometric_screen")
        }) {
            Text("Ir a BiometricScreen")
        }

        Button(onClick = {
            try {
                navController.navigate("notifScreen")
            } catch (e: Exception) {
                Toast.makeText(context, "Error al abrir la pantalla de notificación", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Ir a NotificationScreen")
        }
    }
}

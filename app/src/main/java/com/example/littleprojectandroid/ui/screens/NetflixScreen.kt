package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.littleprojectandroid.R

//topbar
//MovieGamesBar
//ChooseBar
//OrderBar
//Movies
@Composable
fun NetflixScreen(navController: NavHostController){
    Topbar()

}
@Composable
fun Topbar(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(10.dp)
    ){
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu Icon",
            tint = Color.Cyan,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 30.sp,



            )
    }
}

@Composable
fun MovieGamesBar(){
    Row (){
        Column(
            modifier = Modifier
                .padding(0.dp)
        ){ Text("Peliculas y series") }
        Column(
            modifier = Modifier
                .padding(20.dp,0.dp,0.dp,0.dp)
        ) { Text("Juegos") }
    }
}
@Preview(showBackground = true)
@Composable
fun ChooseBar(){
    Row {

    }

}
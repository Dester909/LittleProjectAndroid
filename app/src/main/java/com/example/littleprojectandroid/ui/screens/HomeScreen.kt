package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littleprojectandroid.R

@Composable
fun HomeScreen(navController: NavHostController){
    topbar()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp,60.dp,0.dp,0.dp)
            .verticalScroll(rememberScrollState())
    ){
        ContentOne()
        ContentTwo()
        ContentOne()
        ContentTwo()
        ContentOne()
        ContentTwo()
    }
    /*Column(
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
    }*/

}
@Preview(showBackground = true)
@Composable
fun ContentOne() {
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(9.dp)
    ) {
        Column( // Agregamos una columna para organizar los elementos
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "This is a title",
                fontSize = 24.sp, // `sp` en lugar de `dp` para fuentes
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.outlast), // Se debe reemplazar con una imagen válida
                contentDescription = "AndroidLogo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = R.string.NewText), // Corregido el acceso a recursos de cadenas
                textAlign = TextAlign.Justify,
                lineHeight = 18.sp, // `sp` para texto en lugar de `dp`
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContentTwo() {
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(9.dp)
    ) {
        Row(
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.dompag), // Se debe reemplazar con una imagen válida
                contentDescription = "AndroidLogo",
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    stringResource(R.string.NewText),
                    textAlign = TextAlign.Justify,
                    lineHeight = 14.sp,
                    fontSize = 24.sp, // `sp` en lugar de `dp` para fuentes
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            }
        }
    }
@Composable
fun topbar(){
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






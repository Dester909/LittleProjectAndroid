package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.littleprojectandroid.R


@Composable
fun NetflixScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "← Mi lista",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Categorías (Películas y series / Juegos)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Películas y series",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(
                text = "Juegos",
                color = Color.Gray
            )
        }

        // Línea roja debajo de "Películas y series"
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .width(130.dp)
                .height(2.dp)
                .background(Color.Red)
        )

        // Filtros
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BarSeries("Series")
            BarSeries("Películas")
            BarSeries("Sin empezar")
            BarSeries("Empezados")
        }

        // Ordenar por
        Text(
            text = "Ordenar por Títulos sugeridos ▼",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )

        // Lista de contenido
        ListaContenido("ONE PIECE", R.drawable.onepiece)
        ListaContenido("Agente Stone", R.drawable.agentstone)
        ListaContenido("Fuga de reinas", R.drawable.fugadereinas)
        ListaContenido("Nowhere", R.drawable.nowhere)
        ListaContenido("La gran seducción", R.drawable.lagranseduccion)
        ListaContenido("Madre de alquiler", R.drawable.madredealquiler)
        ListaContenido("Proyecto Extracción", R.drawable.proyectoextraccion)
    }
}

@Composable
fun BarSeries(text: String) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(horizontal = 12.dp, vertical = 6.dp)

    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ListaContenido(title: String, imageRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Miniatura
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .width(120.dp)
                .height(70.dp),
            contentScale = ContentScale.Crop
        )

        // Título
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )

        // Botón de reproducir
        Button(
            onClick = { },
            modifier = Modifier
                .background(Color.Transparent)
        ) {
            Text("▶", color = Color.White)
        }
    }
}
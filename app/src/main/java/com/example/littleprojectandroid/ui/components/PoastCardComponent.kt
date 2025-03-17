package com.example.littleprojectandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littleprojectandroid.R

@Composable
fun PoastCardComponent(id:Int, title:String, text:String, image:Int) {
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
                text = title,
                fontSize = 24.sp, // `sp` en lugar de `dp` para fuentes
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(image), // Se debe reemplazar con una imagen válida
                contentDescription = "AndroidLogo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = text,
                //stringResource(id = R.string.NewText), // Corregido el acceso a recursos de cadenas
                textAlign = TextAlign.Justify,
                lineHeight = 18.sp, // `sp` para texto en lugar de `dp`
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
@Composable
fun PostCardCompactContent(id:Int, title:String, text:String, image:Int) {
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
                painter = painterResource(image), // Se debe reemplazar con una imagen válida
                contentDescription = "AndroidLogo",
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = title,
                    textAlign = TextAlign.Justify,
                    lineHeight = 14.sp,
                    fontSize = 24.sp, // `sp` en lugar de `dp` para fuentes
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}
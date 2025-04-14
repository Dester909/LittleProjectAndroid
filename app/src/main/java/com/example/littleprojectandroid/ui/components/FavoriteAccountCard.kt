package com.example.littleprojectandroid.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.littleprojectandroid.R

@Composable
fun FavoriteAccountCard(
    id: Int,
    name: String,
    username: String,
    password: String,
    description: String,
    imageURL: String,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp), // Padding similar a AccountDetailCardComponent
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), // Padding interno
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del servicio
            AsyncImage(
                model = imageURL, // Usar imageURL correctamente
                error = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Account Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            // Espacio entre la imagen y los datos
            Spacer(modifier = Modifier.width(12.dp))

            // Datos de la cuenta en un Column
            Column(
                modifier = Modifier
                    .weight(1f) // Ocupar el espacio disponible
            ) {
                Text(
                    text = "Nombre: $name",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Usuario: $username",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp
                )
                Text(
                    text = "Contraseña: $password",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp
                )
                Text(
                    text = "Descripción: $description",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp
                )
            }

            // Ícono de eliminar
            IconButton(onClick = { onDeleteClick() }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete account"
                )
            }
        }
    }
}
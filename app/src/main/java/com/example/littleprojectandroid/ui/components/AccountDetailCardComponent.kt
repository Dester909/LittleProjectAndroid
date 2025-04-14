package com.example.littleprojectandroid.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit // Ícono de edición
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.littleprojectandroid.R

@Composable
fun AccountDetailCardComponent(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onSaveClick: () -> Unit,
    navController: NavController
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = imageURL,
                    error = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Account Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Row {
                    IconButton(
                        onClick = { onSaveClick() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Save as Favorite"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            val accountInfo = """
                                Nombre: $name
                                Usuario: $username
                                Contraseña: $password
                                Descripción: $description
                            """.trimIndent()

                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("Account Info", accountInfo)
                            clipboard.setPrimaryClip(clip)

                            Toast.makeText(context, "Información copiada", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Copy Account Info"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            // Navegamos a ManageAccountScreen pasando el ID de la cuenta
                            navController.navigate("manage_account/$id")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Edit Account"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Nombre: $name",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Usuario: $username",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Contraseña: $password",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Descripción: $description",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
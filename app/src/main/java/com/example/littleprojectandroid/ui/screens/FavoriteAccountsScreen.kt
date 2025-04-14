package com.example.littleprojectandroid.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littleprojectandroid.data.database.AppDatabase
import com.example.littleprojectandroid.data.database.DatabaseProvider
import com.example.littleprojectandroid.data.model.AccountEntity
import com.example.littleprojectandroid.ui.components.FavoriteAccountCard
import com.example.littleprojectandroid.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun FavoriteAccountsScreen(navController: NavController) {
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        accountsdb = withContext(Dispatchers.IO) {
            accountDao.getALL()
        }
        isLoading = false
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarComponent(
            "Favorite accounts",
            navController,
            "Favorite_Accounts_Screen"
        )

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (accountsdb.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No favorite accounts found.")
            }
        } else {
            val listState = rememberLazyListState()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState,
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(accountsdb) { accountdb ->
                    FavoriteAccountCard(
                        id = accountdb.id ?: 0,
                        name = accountdb.name ?: "",
                        username = accountdb.username ?: "",
                        password = accountdb.password ?: "",
                        description = accountdb.description ?: "",
                        imageURL = accountdb.imageURL ?: "",
                        onDeleteClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                try{
                                    accountDao.delete(accountdb)
                                    accountsdb = withContext(Dispatchers.IO){
                                        accountDao.getALL()
                                    }

                                }catch (exception: Exception){
                                    Log.d("debug-db","Error: $exception")
                                }

                            }
                        }
                    )
                }
            }
        }
    }
}
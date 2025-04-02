package com.example.littleprojectandroid.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.littleprojectandroid.data.model.AccountModel
import com.example.littleprojectandroid.data.viewmodel.AccountViewModel
import com.example.littleprojectandroid.ui.components.AccountCardComponent
import com.example.littleprojectandroid.ui.components.TopBarComponent

@Composable
fun AccountScreen(
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
){
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    Column {
        TopBarComponent("Accounts")
        LaunchedEffect(Unit)  {
            viewModel.getAccounts { response ->
                if (response.isSuccessful){
                    accounts = response.body() ?: emptyList()
                }else{
                    Log.d("debug","Falied to load data")
                }
            }
        }
        }
        //AccountCardComponent(1,"Name","user@gmail.com","")
    }

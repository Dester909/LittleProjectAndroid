package com.example.littleprojectandroid.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.littleprojectandroid.data.model.AccountModel
import com.example.littleprojectandroid.data.model.UserModel
import com.example.littleprojectandroid.data.viewmodel.AccountViewModel
import com.example.littleprojectandroid.data.viewmodel.UserViewModel
import com.example.littleprojectandroid.ui.components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
){
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()

    ) {
        TopBarComponent("Add account", navController,"ManageAccountScreen")

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            label = {"Account Name"},
            onValueChange = {account.value = account.value.copy(name = it)}
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = {"Account Username"},
            onValueChange = {account.value = account.value.copy(name = it)}
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = {"Account Password"},
            onValueChange = {account.value = account.value.copy(name = it)}
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = {"Account Description"},
            onValueChange = {account.value = account.value.copy(name = it)}
        )
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,10.dp),
            onClick = {  }
        ) {
            Text("Save Account")
        }

    }

}

fun tryCreateAccount(
    user:String,
    password:String,
    context: Context,
    viewModel: UserViewModel,
    navController: NavController
){
    if(user == "" || password == ""){
        Toast.makeText(
            context,
            "User or Password can't be empty",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        val user_model = UserModel(0,"", user, password)
        viewModel.loginAPI(user_model){ jsonResponse ->
            val loginStatus = jsonResponse?.get("login")?.asString
            Log.d("debug","LOGIN STATUS $loginStatus")
            if (loginStatus == "success")
                navController.navigate("AccountScreen")
        }
    }
}
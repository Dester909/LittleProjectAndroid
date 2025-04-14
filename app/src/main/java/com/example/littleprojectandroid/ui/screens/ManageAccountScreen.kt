package com.example.littleprojectandroid.ui.screens

import android.content.Context
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.littleprojectandroid.data.model.AccountModel
import com.example.littleprojectandroid.ui.components.TopBarComponent
import com.example.littleprojectandroid.data.viewmodel.AccountViewModel

@Composable
fun ManageAccountScreen(
    navController: NavController,
    accountId: Int? = null,
    viewModel: AccountViewModel = viewModel()
) {
    val context = LocalContext.current
    val account = remember { mutableStateOf(AccountModel()) }

    LaunchedEffect(accountId) {
        if (accountId != null) {
            viewModel.getAccount(accountId) { response ->
                if (response.isSuccessful) {
                    account.value = response.body() ?: AccountModel()
                } else {
                    Toast.makeText(context, "Failed to load account", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ) {
        TopBarComponent(
            title = if (accountId == null) "Add account" else "Edit account",
            navController = navController,
            location = "ManageAccountScreen"
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.name,
            maxLines = 1,
            label = { Text("Account Name") },
            onValueChange = { account.value = account.value.copy(name = it) }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = { Text("Account Username") },
            onValueChange = { account.value = account.value.copy(username = it) }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = { Text("Account Password") },
            onValueChange = { account.value = account.value.copy(password = it) }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = { Text("Account Description") },
            onValueChange = { account.value = account.value.copy(description = it) }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = account.value.imageURL,
            maxLines = 1,
            label = { Text("Image URL") },
            onValueChange = { account.value = account.value.copy(imageURL = it) }
        )

        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            onClick = {
                if (account.value.name.isEmpty() || account.value.username.isEmpty() ||
                    account.value.password.isEmpty() || account.value.description.isEmpty() ||
                    account.value.imageURL.isEmpty()
                ) {
                    Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    if (accountId == null) {
                        viewModel.createAccount(account.value) { response ->
                            if (response.isSuccessful) {
                                Toast.makeText(context, "Account added", Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            } else {
                                Toast.makeText(context, "Failed to add account", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        viewModel.updateAccount(accountId, account.value) { response ->
                            if (response.isSuccessful) {
                                Toast.makeText(context, "Account updated", Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            } else {
                                Toast.makeText(context, "Failed to update account", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        ) {
            Text(if (accountId == null) "Save Account" else "Update Account")
        }
    }
}
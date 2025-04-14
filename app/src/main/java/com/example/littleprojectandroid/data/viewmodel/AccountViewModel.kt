package com.example.littleprojectandroid.data.viewmodel

import com.example.littleprojectandroid.data.model.AccountModel
import com.example.littleprojectandroid.network.RetrofitClient
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class AccountViewModel: ViewModel() {
    val api = RetrofitClient.api

    fun getAccounts(onResult: (Response<List<AccountModel>>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.getAccounts()
                Log.d("debug", response.toString())
                onResult(response)
            } catch (exception: Exception) {
                Log.d("debug", "API ERROR: $exception")
            }
        }
    }

    fun getAccount(id: Int, onResult: (Response<AccountModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.getAccount(id)
                Log.d("debug", response.toString())
                onResult(response)
            } catch (exception: Exception) {
                Log.d("debug", "API ERROR: $exception")
            }
        }
    }

    fun createAccount(service: AccountModel, onResult: (Response<JsonObject>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.addAccount(service)
                Log.d("debug", "MSG: ${response.body()}")
                onResult(response)  // Pasa el response completo
            } catch (exception: Exception) {
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(Response.error(500, null))  // En caso de error, devuelve un Response.error
            }
        }
    }

    fun updateAccount(id: Int, account: AccountModel, onResult: (Response<JsonObject>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.updateAccount(id, account)
                Log.d("debug", "MSG: ${response.body()}")
                onResult(response)  // Pasa el response completo
            } catch (exception: Exception) {
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(Response.error(500, null))  // En caso de error, devuelve un Response.error
            }
        }
    }

    fun deleteAccount(id: Int, onResult: (Response<JsonObject>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.deleteAccount(id)
                Log.d("debug", "MSG: ${response.body()}")
                onResult(response)  // Pasa el response completo
            } catch (exception: Exception) {
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(Response.error(500, null))  // En caso de error, devuelve un Response.error
            }
        }
    }
}

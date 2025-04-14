package com.example.littleprojectandroid.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littleprojectandroid.data.model.UserModel
import com.example.littleprojectandroid.network.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel : ViewModel() {
    val api = RetrofitClient.api

    fun loginAPI(user: UserModel, onResult: (Response<JsonObject>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.login(user)
                if (response.isSuccessful) {
                    Log.d("debug", "Login successful: ${response.body()}")
                    onResult(response)
                } else {
                    Log.d("debug", "Login failed: ${response.message()}")
                    onResult(response)
                }
            } catch (exception: Exception) {
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(Response.error(500, null))
            }
        }
    }
}
package com.example.littleprojectandroid.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.littleprojectandroid.data.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getALL(): List<AccountEntity>
}
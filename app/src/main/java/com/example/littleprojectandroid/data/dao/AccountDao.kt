package com.example.littleprojectandroid.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.littleprojectandroid.data.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getALL(): List<AccountEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: AccountEntity)

    @Delete()
    fun delete(account: AccountEntity)
}
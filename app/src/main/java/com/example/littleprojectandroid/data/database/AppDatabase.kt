package com.example.littleprojectandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.littleprojectandroid.data.dao.AccountDao
import com.example.littleprojectandroid.data.model.AccountEntity

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun accountDao(): AccountDao
}
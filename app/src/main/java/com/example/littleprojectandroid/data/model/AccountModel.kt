package com.example.littleprojectandroid.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class AccountModel(
    var id:Int = 0,
    var name: String = "null",
    var username:String = "null",
    var password:String = "null",
    var description: String = "null",
    var imageURL: String = ""

)
@Entity
data class AccountEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "imageURL") val imageURL: String,
    )
fun AccountModel.toAccountEntity(): AccountEntity{
    return AccountEntity(
        id = this.id,
        name = this.name,
        username = this.username,
        password = this.password,
        description = this.description,
        imageURL = this.imageURL
    )
}

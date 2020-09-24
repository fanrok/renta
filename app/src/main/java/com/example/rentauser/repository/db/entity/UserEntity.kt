package com.example.rentauser.repository.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dmitriy Larin
 */
@Entity(tableName = "users")
data class UserEntity(
    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("login")
    @Expose
    var login: String? = null,

    @SerializedName("pass")
    @Expose
    val pass: String? = null
)
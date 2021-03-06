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

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("first_name")
    @Expose
    val firstName: String? = null,

    @SerializedName("last_name")
    @Expose
    val lastName: String? = null,

    @SerializedName("avatar")
    @Expose
    val avatar: String? = null
)
package com.example.rentauser.repository.remote.models

import com.example.rentauser.repository.db.entity.UserEntity
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("page") val page : Int,
    @SerializedName("per_page") val per_page : Int,
    @SerializedName("total") val total : Int,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("data") val data : List<User>,
    @SerializedName("ad") val ad : Ad
)

data class User (
    @SerializedName("id") val id : Int,
    @SerializedName("email") val email : String,
    @SerializedName("first_name") val first_name : String,
    @SerializedName("last_name") val last_name : String,
    @SerializedName("avatar") val avatar : String
){
    fun toUserEntity() = UserEntity(id, email, first_name, last_name, avatar)
}

data class Ad (
    @SerializedName("company") val company : String,
    @SerializedName("url") val url : String,
    @SerializedName("text") val text : String
)
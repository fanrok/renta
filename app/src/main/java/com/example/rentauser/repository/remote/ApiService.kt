package com.example.rentauser.repository.remote

import com.example.rentauser.repository.remote.models.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Dmitriy Larin
 */
interface ApiService {
    @GET("api/users")
    fun getAllUsers(): Single<UserResponse>
}
package com.example.rentauser.repository.remote

import com.example.rentauser.repository.remote.models.UserResponse
import io.reactivex.Single


/**
 * Created by Dmitriy Larin
 */
class ApiCommunicator (private val apiService: ApiService) {

    fun getAllUsers(): Single<UserResponse> {
        return apiService.getAllUsers()
    }
}
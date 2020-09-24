package com.example.rentauser.repository

import com.example.rentauser.repository.db.AppDatabase
import com.example.rentauser.repository.db.entity.UserEntity
import com.example.rentauser.repository.remote.ApiCommunicator
import com.example.rentauser.repository.remote.models.UserResponse
import io.reactivex.Single


/**
 * Created by Dmitriy Larin
 */
class AppRepository(private val api: ApiCommunicator, private val db: AppDatabase) {

    fun getAllUsersFromNetwork(): Single<UserResponse> {
        return api.getAllUsers()
    }

    fun getAllUsersFromDatabase(): Single<List<UserEntity>> {
        return db.userDao().getAll()
    }

    fun updateAllUsersInDatabase(list: List<UserEntity>):Single<List<Long>>{
        return db.userDao().insertList(list)
    }

    fun getUserFromFromDatabaseById(id: Int): Single<UserEntity> {
        return db.userDao().getById(id)
    }

}
package com.example.rentauser.repository

import com.example.rentauser.repository.db.AppDatabase
import com.example.rentauser.repository.remote.ApiCommunicator


/**
 * Created by Dmitriy Larin
 */
class AppRepository(private val api: ApiCommunicator, private val db: AppDatabase) {

//    fun getUser():Single<UserEntity>{
//        return db.userDao().getById(1)
//    }


}
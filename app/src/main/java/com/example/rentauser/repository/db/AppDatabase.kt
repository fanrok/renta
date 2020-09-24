package com.example.rentauser.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rentauser.repository.db.dao.UserDao
import com.example.rentauser.repository.db.entity.UserEntity

/**
 * Created by Dmitriy Larin
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
package com.example.rentauser.repository.db.dao

import androidx.room.*
import com.example.rentauser.repository.db.entity.UserEntity
import io.reactivex.Single

/**
 * Created by Dmitriy Larin
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Int): Single<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity): Single<Long>

    @Delete
    fun delete(userEntity: UserEntity)
}
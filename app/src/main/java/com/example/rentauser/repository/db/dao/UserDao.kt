package com.example.rentauser.repository.db.dao

import androidx.room.*
import com.example.rentauser.repository.db.entity.UserEntity
import io.reactivex.Single

/**
 * Created by Dmitriy Larin
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): Single<List<UserEntity>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Int): Single<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<UserEntity>): Single<List<Long>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(userEntity: UserEntity)

    @Update
    fun updateAll(list: List<UserEntity>)

    @Delete
    fun delete(userEntity: UserEntity)
}
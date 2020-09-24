package com.example.rentauser.di.modules

import com.example.rentauser.repository.db.AppDatabase
import dagger.Module
import dagger.Provides

/**
 * Created by Dmitriy Larin
 */
@Module
class DatabaseModule(private val appDatabase: AppDatabase) {
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }
}
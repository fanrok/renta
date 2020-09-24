package com.example.rentauser.di.modules

import com.example.rentauser.di.scope.RepositoryScope
import com.example.rentauser.repository.AppRepository
import com.example.rentauser.repository.db.AppDatabase
import com.example.rentauser.repository.remote.ApiCommunicator
import dagger.Module
import dagger.Provides

/**
 * Created by Dmitriy Larin
 */
@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    fun providesRepository(api: ApiCommunicator, db: AppDatabase): AppRepository {
        return AppRepository(api, db)
    }
}
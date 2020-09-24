package com.example.rentauser

import android.app.Application
import androidx.room.Room
import com.example.rentauser.di.components.DaggerApiComponent
import com.example.rentauser.di.components.DaggerDatabaseComponent
import com.example.rentauser.di.components.DaggerRepositoryComponent
import com.example.rentauser.di.components.DaggerViewModelComponent
import com.example.rentauser.di.components.ViewModelComponent
import com.example.rentauser.di.modules.ApiModule
import com.example.rentauser.di.modules.DatabaseModule
import com.example.rentauser.di.modules.RepositoryModule
import com.example.rentauser.di.modules.ViewModelModule
import com.example.rentauser.repository.db.AppDatabase

/**
 * Created by Dmitriy Larin
 */
class App: Application() {
    private lateinit var db: AppDatabase
    private lateinit var viewModelComponent: ViewModelComponent

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        db = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this.db))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .repositoryComponent(repositoryComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent
    }
}
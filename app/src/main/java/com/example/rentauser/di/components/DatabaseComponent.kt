package com.example.rentauser.di.components

import com.example.rentauser.di.modules.DatabaseModule
import com.example.rentauser.repository.db.AppDatabase
import dagger.Component

/**
 * Created by Dmitriy Larin
 */
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}
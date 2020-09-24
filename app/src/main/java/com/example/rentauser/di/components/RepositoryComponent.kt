package com.example.rentauser.di.components

import com.example.rentauser.di.modules.RepositoryModule
import com.example.rentauser.di.scope.RepositoryScope
import com.example.rentauser.repository.AppRepository
import dagger.Component

/**
 * Created by Dmitriy Larin
 */
@RepositoryScope
@Component(
    modules = [RepositoryModule::class],
    dependencies = [ApiComponent::class, DatabaseComponent::class]
)
interface RepositoryComponent {
    val repository: AppRepository
}
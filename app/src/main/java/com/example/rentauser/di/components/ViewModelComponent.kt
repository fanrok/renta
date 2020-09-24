package com.example.rentauser.di.components

import com.example.rentauser.di.modules.ViewModelModule
import com.example.rentauser.di.scope.ViewModelScope
import com.example.rentauser.ui.main.AboutFragment
import com.example.rentauser.ui.main.DetailFragment
import com.example.rentauser.ui.main.ListFragment
import dagger.Component

/**
 * Created by Dmitriy Larin
 */
@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(fragment: AboutFragment)
    fun inject(fragment: ListFragment)
    fun inject(fragment: DetailFragment)
}
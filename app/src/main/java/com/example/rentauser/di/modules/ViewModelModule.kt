package com.example.rentauser.di.modules

import android.app.Application
import com.example.rentauser.App
import com.example.rentauser.ui.main.MainViewModel
import com.example.rentauser.di.scope.ViewModelScope
import com.example.rentauser.repository.AppRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Dmitriy Larin
 */
@Module
class ViewModelModule(app: App) {
    var app: Application = app

    @ViewModelScope
    @Provides
    fun providesMainViewModel(repository: AppRepository): MainViewModel {
        return MainViewModel(app, repository)
    }
}
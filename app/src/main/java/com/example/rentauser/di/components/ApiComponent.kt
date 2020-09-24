package com.example.rentauser.di.components

import com.example.rentauser.di.modules.ApiModule
import com.example.rentauser.di.scope.ApiScope
import com.example.rentauser.repository.remote.ApiCommunicator
import dagger.Component

/**
 * Created by Dmitriy Larin
 */

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ApiCommunicator
}
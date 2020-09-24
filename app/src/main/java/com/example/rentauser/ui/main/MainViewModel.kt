package com.example.rentauser.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rentauser.repository.AppRepository

class MainViewModel (application: Application, private val repository: AppRepository) :
        AndroidViewModel(application) {


}
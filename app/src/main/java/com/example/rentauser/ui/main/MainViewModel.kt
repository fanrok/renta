package com.example.rentauser.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rentauser.repository.AppRepository
import com.example.rentauser.repository.db.entity.UserEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel (application: Application, private val repository: AppRepository) :
        AndroidViewModel(application) {
        private val dispose = CompositeDisposable()
        val liveDataAllUsers = MutableLiveData<List<UserEntity>>()
        val userLiveData = MutableLiveData<UserEntity>()
        val errorLiveData = MutableLiveData<String>()

        init {
                loadAllUsersFromNetwork()
                liveDataAllUsers.value = listOf(UserEntity(0,"", "", "", ""))
        }

        fun loadUser(id:Int){
                dispose.add(
                        repository.getUserFromFromDatabaseById(id)
                                .retry()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ it ->
                                        userLiveData.value = it
                                }, {})
                )
        }

        private fun loadAllUsersFromNetwork() {
                dispose.add(
                        repository.getAllUsersFromNetwork()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ it ->
                                        val outList = mutableListOf<UserEntity>()
                                        it.data.map {user ->
                                                outList.add(user.toUserEntity())
                                        }
                                        liveDataAllUsers.value = outList
                                        updateDatabase(outList)
                                }, {
                                        loadAllUsersFromDatabase()
                                        errorLiveData.value = it.message.toString()
                                })
                )
        }

        private fun loadAllUsersFromDatabase() {
                dispose.add(
                        repository.getAllUsersFromDatabase()
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({
                                        Log.d("TAG" + it.size, it.toString())
                                        liveDataAllUsers.value = it
                                }, { Log.d("TAG", it.message.toString()) })
                )
        }

        private fun updateDatabase(list: List<UserEntity>) {
                dispose.add(
                        repository.updateAllUsersInDatabase(list)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({}, {})
                )
        }

        override fun onCleared() {
                super.onCleared()
                dispose.dispose()
        }
}
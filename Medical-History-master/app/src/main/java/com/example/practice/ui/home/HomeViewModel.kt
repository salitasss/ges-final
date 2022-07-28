package com.example.practice.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.practice.Room.UserDao
import com.example.practice.Room.UserDatabase
import com.example.practice.UserRepository
import com.example.practice.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    val database: UserDao,
    application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>

    private val repository: UserRepository

    val nights = database.getAllNights()

    init {
        val userDao = UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun upDateData(user: User){
        viewModelScope.launch {
            repository.upDateData(user)
        }
    }

    fun deleteData(user: User){
        viewModelScope.launch {
            repository.deleteData(user)
        }
    }
}
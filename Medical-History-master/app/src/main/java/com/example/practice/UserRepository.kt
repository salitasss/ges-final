package com.example.practice

import androidx.lifecycle.LiveData
import com.example.practice.Room.UserDao
import com.example.practice.models.User

class UserRepository(private val userDao: UserDao) {

   val readAllData: LiveData<List<User>> = userDao.readAllData()

   suspend fun addUser(user: User){
        userDao.addUser(user)
   }

   suspend fun upDateData(user: User){
        userDao.upDateData(user)
   }

   suspend fun deleteData(user: User){
        userDao.deleteData(user)
   }
}
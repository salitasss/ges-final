package com.example.practice.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.practice.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY stat_id ASC ")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_table ORDER BY stat_id DESC")
    fun getAllNights(): LiveData<List<User>>

    @Update
    suspend fun upDateData(user: User)

    @Delete
    suspend fun deleteData(user: User)

    //needed for HomeViewModel
    //have no use for it
    @Query("SELECT * FROM user_table ORDER BY stat_id DESC LIMIT 1")
    fun getTonight(): User?
}
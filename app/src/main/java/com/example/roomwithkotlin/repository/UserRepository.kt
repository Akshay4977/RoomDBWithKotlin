package com.example.roomwithkotlin.repository

import androidx.lifecycle.LiveData
import com.example.roomwithkotlin.data.UserDao
import com.example.roomwithkotlin.models.User1
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User1>> = userDao.readAllData()

    suspend fun addUser(user: User1) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User1) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User1) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }

     fun searchDatabase(query: String) : Flow<List<User1>> {
        return userDao.searchDatabase(query)
    }
}
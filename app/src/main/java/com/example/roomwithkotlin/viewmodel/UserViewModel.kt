package com.example.roomwithkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomwithkotlin.data.UserDatabase
import com.example.roomwithkotlin.models.User1
import com.example.roomwithkotlin.repository.UserRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User1>>
    private val repository: UserRepository

    init {
        val useDao = UserDatabase.getDatabase(
            application
        ).UserDao()
        repository = UserRepository(useDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User1) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User1) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User1) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }

    fun searchDatabase(searchQuery : String): LiveData<List<User1>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }
}

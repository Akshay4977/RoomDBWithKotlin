package com.example.roomwithkotlin.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomwithkotlin.models.User1
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User1)


    @Query("select * FROM user ORDER BY id ASC")
    fun readAllData(): LiveData<List<User1>>

    @Update
    suspend fun updateUser(user: User1)

    @Delete
    suspend fun deleteUser(user: User1)

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

    @Query("SELECT * FROM user WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<User1>>
}

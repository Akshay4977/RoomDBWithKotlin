package com.example.roomwithkotlin.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.roomwithkotlin.test.getOrAwaitValue
import com.example.roomwithkotlin.models.User1
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {

    @get:Rule
    var instanceTask = InstantTaskExecutorRule()

    private lateinit var database: UserDatabase
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = database.UserDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val user = User1(1, "ami", 41)
        userDao.addUser(user)


        val allUser = userDao.readAllData().getOrAwaitValue()
        assertThat(allUser).contains(user)
    }

    @Test
    fun deleteItem() = runBlockingTest{
        val user = User1(2, "amii", 41)
        userDao.addUser(user)
        userDao.deleteUser(user)

        val allUser = userDao.readAllData().getOrAwaitValue()
        assertThat(allUser).doesNotContain(user)
    }
}
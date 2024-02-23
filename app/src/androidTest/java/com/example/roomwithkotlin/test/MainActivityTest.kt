package com.example.roomwithkotlin.test


import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.roomwithkotlin.MainActivity
import com.example.roomwithkotlin.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    val user = "aks"
    val pass = "pass"


    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Before
    fun setUp() {
        Log.e("inside", "done")
    }

    @Test
    fun temp() {

        onView(withId(R.id.user_text_view)).perform(ViewActions.typeText(user.toString()))
        onView(withId(R.id.pass_text_view)).perform(ViewActions.typeText(pass.toString()))
        Thread.sleep(2000)

        onView(withId(R.id.login_button)).perform(click())

        onView(withText(user)).check(matches(isDisplayed()))
        onView(withText(pass)).check(matches(isDisplayed()))
    }
}

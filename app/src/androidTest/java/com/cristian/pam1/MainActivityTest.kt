package com.cristian.pam1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cristian.pam1.ui.view.Welcome
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest


@RunWith(AndroidJUnit4::class)
class MainActivityTest: KoinTest {
    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(Welcome::class.java)
        onView(withId(R.id.next)).check(matches(isDisplayed()))
        onView(withId(R.id.mute_unmute)).check(matches(isDisplayed()))
        onView(withId(R.id.text_input)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.dfn_op)).check(matches(isDisplayed()))
    }
    @Test
    fun test_navSecondActivity(){
        val activityScenario = ActivityScenario.launch(Welcome::class.java)
        onView(withId(R.id.next)).perform(click())
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_navFirstActivity(){
        val activityScenario = ActivityScenario.launch(Welcome::class.java)
        pressBack()
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()))
    }
}
package com.cristian.pam1

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cristian.pam1.ui.view.ContentFragment
import com.cristian.pam1.ui.view.FragmentProfile
import com.cristian.pam1.ui.view.FragmentSettings

@RunWith(AndroidJUnit4::class)
class FragmentsTest {
    @Test
    fun test_contentFragment(){
        val scenario = launchFragmentInContainer<ContentFragment>()
        Espresso.onView(withId(R.id.search_button)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.input)).check(matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun test_profileFragment(){
        val scenario = launchFragmentInContainer<FragmentProfile>()
        Espresso.onView(withId(R.id.search_button)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.input)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.description)).check(matches(withText("Welcome")))
    }
    @Test
    fun test_settingsFragment(){
        val scenario = launchFragmentInContainer<FragmentSettings>()
        Espresso.onView(withId(R.id.textView)).check(matches(ViewMatchers.isDisplayed()))
    }
}
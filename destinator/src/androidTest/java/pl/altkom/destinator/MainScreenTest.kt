package pl.altkom.destinator

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import pl.altkom.destinator.presentation.screen.MainActivity

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun titleLabel() {
        onView(withId(R.id.labelka)).check(
            matches(
                allOf(
                    withText("Destinations list"),
                    isDisplayed()
                )
            )
        )
        rule.scenario.onActivity {
            assertEquals("Destinations list", it.findViewById<TextView>(R.id.labelka).text)
        }
    }
}
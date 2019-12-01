package id.cybershift.fakhrimovie.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.cybershift.fakhrimovie.MainActivity;
import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.utils.EspressoIdlingResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FakhriMovieTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void toDetailActivityFromMovieFragment() {
        onView(withId(R.id.movie_rv)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_cl)).check(matches(isDisplayed()));
    }

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void toDetailActivityFromTVShowFragment() {
        onView(withId(R.id.navigation)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_tvshow)).perform(click());
        onView(withId(R.id.tvshow_rv)).check(matches(isDisplayed()));
        onView(withId(R.id.tvshow_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_cl)).check(matches(isDisplayed()));
    }
}

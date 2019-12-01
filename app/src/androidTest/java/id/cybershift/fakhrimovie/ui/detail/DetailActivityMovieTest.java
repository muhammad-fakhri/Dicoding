package id.cybershift.fakhrimovie.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.logging.Handler;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.utils.EspressoIdlingResource;
import id.cybershift.fakhrimovie.utils.FakeDataSource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityMovieTest {
    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(context, DetailActivity.class);
            result.putExtra(DetailActivity.EXTRA_ITEM_POSITION, 0);
            result.putExtra(DetailActivity.EXTRA_ITEM_TYPE, "movie");
            return result;
        }
    };
    private MovieEntity dummyMovie = FakeDataSource.getMoviesData().get(0);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        onView(withId(R.id.detail_name)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_name)).check(matches(withText(dummyMovie.getTitle())));
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_description)).check(matches(withText(dummyMovie.getOverview())));
        onView(withId(R.id.detail_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rate)).check(matches(withText(String.valueOf(dummyMovie.getRate()))));
        onView(withId(R.id.detail_year)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_year)).check(matches(withText(dummyMovie.getYear())));
        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()));
    }
}
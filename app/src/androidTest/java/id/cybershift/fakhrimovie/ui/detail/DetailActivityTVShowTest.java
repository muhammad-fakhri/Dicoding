package id.cybershift.fakhrimovie.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.utils.FakeDataSource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTVShowTest {
    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule = new ActivityTestRule<DetailActivity>(DetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ITEM_POSITION, 0);
            intent.putExtra(DetailActivity.EXTRA_ITEM_TYPE, "tv");
            return intent;
        }
    };
    private TVShowEntity dummyTVShow = FakeDataSource.getTVShowsData().get(0);

    @Before
    public void setUp() {
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTVShows() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.detail_name)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_name)).check(matches(withText(dummyTVShow.getTitle())));
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_description)).check(matches(withText(dummyTVShow.getOverview())));
        onView(withId(R.id.detail_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rate)).check(matches(withText(String.valueOf(dummyTVShow.getRate()))));
        onView(withId(R.id.detail_year)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_year)).check(matches(withText(dummyTVShow.getYear())));
        onView(withId(R.id.detail_poster)).check(matches(isDisplayed()));
    }

}
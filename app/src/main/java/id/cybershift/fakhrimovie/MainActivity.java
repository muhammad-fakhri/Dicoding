package id.cybershift.fakhrimovie;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import id.cybershift.fakhrimovie.ui.SectionsPagerAdapter;
import id.cybershift.fakhrimovie.ui.favorite.FavoriteFragment;
import id.cybershift.fakhrimovie.ui.movie.MovieFragment;
import id.cybershift.fakhrimovie.ui.tvshow.TVShowFragment;

public class MainActivity extends AppCompatActivity {
    boolean typeMovie = true;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = menuItem -> {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MovieFragment movieFragment = new MovieFragment();
        TVShowFragment tvShowFragment = new TVShowFragment();
        FavoriteFragment favoriteFragment = new FavoriteFragment();
        Fragment fragment;

        switch (menuItem.getItemId()) {
            case R.id.navigation_movie:
                typeMovie = true;
                fragment = fragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());
                if (!(fragment instanceof MovieFragment)) {
                    fragmentTransaction.replace(R.id.container_layout, movieFragment, MovieFragment.class.getSimpleName());
                    fragmentTransaction.commit();
                }
                return true;
            case R.id.navigation_tvshow:
                typeMovie = false;
                fragment = fragmentManager.findFragmentByTag(TVShowFragment.class.getSimpleName());
                if (!(fragment instanceof TVShowFragment)) {
                    fragmentTransaction.replace(R.id.container_layout, tvShowFragment, TVShowFragment.class.getSimpleName());
                    fragmentTransaction.commit();
                }
                return true;
            case R.id.navigation_favorite:
                typeMovie = true;
                fragment = fragmentManager.findFragmentByTag(FavoriteFragment.class.getSimpleName());
                if (!(fragment instanceof FavoriteFragment)) {
                    fragmentTransaction.replace(R.id.container_layout, favoriteFragment, FavoriteFragment.class.getSimpleName());
                    fragmentTransaction.commit();
                }
                return true;
            default:
                return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.navigation_movie);
        }
    }
}
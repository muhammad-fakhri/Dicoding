package id.cybershift.fakhrimovie.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.ui.favorite.moviefavorite.FavoriteMovieFragment;
import id.cybershift.fakhrimovie.ui.favorite.tvshowfavorite.FavoriteTVShowFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        //Set TabLayout
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Movie"));
        tabLayout.addTab(tabLayout.newTab().setText("TV Show"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            FavoriteMovieFragment favoriteMovieFragment = new FavoriteMovieFragment();
            FavoriteTVShowFragment favoriteTVShowFragment = new FavoriteTVShowFragment();

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                if (tab.getText() == "Movie") {
                    fragmentTransaction.replace(R.id.favorite_child_fragment, favoriteMovieFragment);
                } else if (tab.getText() == "TV Show") {
                    fragmentTransaction.replace(R.id.favorite_child_fragment, favoriteTVShowFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                if (tab.getText() == "Movie") {
                    fragmentTransaction.replace(R.id.favorite_child_fragment, favoriteMovieFragment);
                } else if (tab.getText() == "TV Show") {
                    fragmentTransaction.replace(R.id.favorite_child_fragment, favoriteTVShowFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();
    }
}

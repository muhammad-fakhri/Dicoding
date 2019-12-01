package id.cybershift.fakhrimovie.ui.favorite.tvshowfavorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.viewmodel.ViewModelFactory;

public class FavoriteTVShowFragment extends Fragment {

    private FavoriteTVShowViewModel viewModel;
    private RecyclerView rvFavTVShow;
    private ProgressBar progressBar;
    private TextView emptyTVShow;
    //    private FavoriteTVShowAdapter adapter;
    private FavTVShowPagedAdapter adapter;
    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                FavoriteEntity favoriteEntity = adapter.getItemById(swipedPosition);
                viewModel.deleteFavoriteTVShow(favoriteEntity);
                Snackbar snackbar = Snackbar.make(getView(), "Unfavoriting " + favoriteEntity.getTitle(), Snackbar.LENGTH_LONG);
//                snackbar.setAction(R.string.message_ok, v -> viewModel.setBookmark(favoriteEntity));
                snackbar.show();
            }
        }
    });

    public static FavoriteTVShowFragment newInstance() {
        return new FavoriteTVShowFragment();
    }

    @NonNull
    private static FavoriteTVShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoriteTVShowViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_tvshow_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavTVShow = view.findViewById(R.id.favorite_tvshow_rv);
        progressBar = view.findViewById(R.id.favorite_tvshow_pb);
        emptyTVShow = view.findViewById(R.id.emptyTVShow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressBar.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
//            adapter = new FavoriteTVShowAdapter();
            adapter = new FavTVShowPagedAdapter();
//            adapter.setActivity(this.getActivity());

            viewModel = obtainViewModel(getActivity());
            viewModel.getAllFavoriteTVShowsPaged().observe(this, favoriteTVShows -> {
                progressBar.setVisibility(View.GONE);
                if (favoriteTVShows.size() == 0) {
                    emptyTVShow.setVisibility(View.VISIBLE);
                } else {
                    emptyTVShow.setVisibility(View.GONE);
                }
//                adapter.setListFavorites(favoriteTVShows);
                adapter.submitList(favoriteTVShows);
                adapter.setViewModel(viewModel);
                adapter.notifyDataSetChanged();
            });

            rvFavTVShow.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFavTVShow.setHasFixedSize(true);
            rvFavTVShow.setAdapter(adapter);

            itemTouchHelper.attachToRecyclerView(rvFavTVShow);
        }
    }
}

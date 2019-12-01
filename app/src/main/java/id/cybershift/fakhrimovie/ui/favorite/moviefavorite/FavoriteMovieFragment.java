package id.cybershift.fakhrimovie.ui.favorite.moviefavorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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

public class FavoriteMovieFragment extends Fragment {
    private RecyclerView rvFavMovie;
    private FavoriteMovieViewModel viewModel;
    private ProgressBar progressBar;
    //    private FavoriteMovieAdapter adapter;
    private FavMoviePagedAdapter adapter;

    public static FavoriteMovieFragment newInstance() {
        return new FavoriteMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_movie_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavMovie = view.findViewById(R.id.favorite_movie_rv);
        progressBar = view.findViewById(R.id.favorite_movie_pb);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressBar.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
//            adapter = new FavoriteMovieAdapter();
            adapter = new FavMoviePagedAdapter();
//            adapter.setActivity(this.getActivity());

            viewModel = obtainViewModel(getActivity());
            viewModel.getAllFavoriteMoviePaged().observe(this, favoriteMovies -> {
                progressBar.setVisibility(View.GONE);
//                adapter.setListFavorites(favoriteMovies);
                adapter.submitList(favoriteMovies);
                adapter.setViewModel(viewModel);
                adapter.notifyDataSetChanged();
            });

            rvFavMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFavMovie.setHasFixedSize(true);
            rvFavMovie.setAdapter(adapter);

            itemTouchHelper.attachToRecyclerView(rvFavMovie);
        }
    }

    @NonNull
    private static FavoriteMovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoriteMovieViewModel.class);
    }

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
                viewModel.deleteFavoriteMovie(favoriteEntity);
                Snackbar snackbar = Snackbar.make(getView(), "Unfavoriting "+favoriteEntity.getTitle(), Snackbar.LENGTH_LONG);
//                snackbar.setAction(R.string.message_ok, v -> viewModel.setBookmark(favoriteEntity));
                snackbar.show();
            }
        }
    });
}

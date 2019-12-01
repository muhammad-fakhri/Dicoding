package id.cybershift.fakhrimovie.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.di.Injection;
import id.cybershift.fakhrimovie.ui.detail.DetailViewModel;
import id.cybershift.fakhrimovie.ui.favorite.moviefavorite.FavoriteMovieViewModel;
import id.cybershift.fakhrimovie.ui.favorite.tvshowfavorite.FavoriteTVShowViewModel;
import id.cybershift.fakhrimovie.ui.movie.MovieViewModel;
import id.cybershift.fakhrimovie.ui.tvshow.TVShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final CatalogueRepository catalogueRepository;

    private ViewModelFactory(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(TVShowViewModel.class)) {
            return (T) new TVShowViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(FavoriteMovieViewModel.class)) {
            return (T) new FavoriteMovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(FavoriteTVShowViewModel.class)) {
            return (T) new FavoriteTVShowViewModel(catalogueRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

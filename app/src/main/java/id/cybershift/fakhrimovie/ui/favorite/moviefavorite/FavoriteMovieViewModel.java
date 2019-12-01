package id.cybershift.fakhrimovie.ui.favorite.moviefavorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import java.util.List;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

public class FavoriteMovieViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private CatalogueRepository catalogueRepository;

    public FavoriteMovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<PagedList<FavoriteEntity>> getAllFavoriteMoviePaged() {
        return catalogueRepository.getAllFavoriteMovie();
    }

    void deleteFavoriteMovie(FavoriteEntity favoriteEntity){
        catalogueRepository.deleteFavorite(favoriteEntity);
    }
}

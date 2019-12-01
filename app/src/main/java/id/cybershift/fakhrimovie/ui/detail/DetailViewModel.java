package id.cybershift.fakhrimovie.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;

public class DetailViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;
    private int position;

    public DetailViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    LiveData<MovieEntity> getMovieByPosition() {
        return catalogueRepository.getMovie(position);
    }

    LiveData<TVShowEntity> getTVShowByPosition() {
        return catalogueRepository.getTVShow(position);
    }

    void insertFavorite(FavoriteEntity favoriteEntity) {
        catalogueRepository.insertFavorite(favoriteEntity);
    }
}

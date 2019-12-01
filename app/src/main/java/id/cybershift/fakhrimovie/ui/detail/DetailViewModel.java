package id.cybershift.fakhrimovie.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.CatalogueRepository;

public class DetailViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;
    private int position;

    public DetailViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public LiveData<MovieEntity> getMovieByPosition() {
        return catalogueRepository.getMovie(position);
    }

    public LiveData<TVShowEntity> getTVShowByPosition() {
        return catalogueRepository.getTVShow(position);
    }
}

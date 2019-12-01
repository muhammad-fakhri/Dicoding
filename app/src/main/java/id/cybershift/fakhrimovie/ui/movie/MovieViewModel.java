package id.cybershift.fakhrimovie.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;

public class MovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public MovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<ArrayList<MovieEntity>> getMovies() {
        return catalogueRepository.getAllMovies();
    }
}

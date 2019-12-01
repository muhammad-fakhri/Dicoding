package id.cybershift.fakhrimovie.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.CatalogueRepository;

public class TVShowViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public TVShowViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<ArrayList<TVShowEntity>> getTVShows() {
        return catalogueRepository.getAllTVShows();
    }
}

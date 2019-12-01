package id.cybershift.fakhrimovie.ui.favorite.tvshowfavorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import java.util.List;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

public class FavoriteTVShowViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private CatalogueRepository catalogueRepository;

    public FavoriteTVShowViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<PagedList<FavoriteEntity>> getAllFavoriteTVShowsPaged() {
        return catalogueRepository.getAllFavoriteTVShow();
    }

    void deleteFavoriteTVShow(FavoriteEntity favoriteEntity) {
        catalogueRepository.deleteFavorite(favoriteEntity);
    }
}

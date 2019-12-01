package id.cybershift.fakhrimovie.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;

public interface CatalogueDataSource {
    LiveData<ArrayList<MovieEntity>> getAllMovies();

    LiveData<ArrayList<TVShowEntity>> getAllTVShows();

    LiveData<MovieEntity> getMovie(int position);

    LiveData<TVShowEntity> getTVShow(int position);

    //    LiveData<List<FavoriteEntity>> getAllFavoriteMovie();
    LiveData<PagedList<FavoriteEntity>> getAllFavoriteMovie();

    //    LiveData<List<FavoriteEntity>> getAllFavoriteTVShow();
    LiveData<PagedList<FavoriteEntity>> getAllFavoriteTVShow();

    void insertFavorite(FavoriteEntity favoriteEntity);

    void deleteFavorite(FavoriteEntity favoriteEntity);


}

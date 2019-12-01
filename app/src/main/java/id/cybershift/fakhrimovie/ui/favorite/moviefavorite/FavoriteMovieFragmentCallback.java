package id.cybershift.fakhrimovie.ui.favorite.moviefavorite;

import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

interface FavoriteMovieFragmentCallback {
    void onShareClick(FavoriteEntity favoriteEntity);
}

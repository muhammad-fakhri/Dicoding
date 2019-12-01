package id.cybershift.fakhrimovie.data.source.local.room;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

@Dao
public interface CatalogueDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavorite(FavoriteEntity favoriteEntity);

    @Delete()
    void deleteFavorite(FavoriteEntity favoriteEntity);

//    @Query("SELECT * FROM favorite WHERE type = 0")
//    LiveData<List<FavoriteEntity>> getAllFavoriteMovie();

    @Query("SELECT * FROM favorite WHERE type = 0")
    DataSource.Factory<Integer, FavoriteEntity> getAllFavoriteMovieAsPaged();

//    @Query("SELECT * FROM favorite WHERE type = 1")
//    LiveData<List<FavoriteEntity>> getAllFavoriteTVShow();

    @Query("SELECT * FROM favorite WHERE type = 1")
    DataSource.Factory<Integer, FavoriteEntity> getAllFavoriteTVShowAsPaged();
}

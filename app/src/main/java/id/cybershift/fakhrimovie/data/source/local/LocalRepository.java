package id.cybershift.fakhrimovie.data.source.local;

import android.app.Application;

import androidx.paging.DataSource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.data.source.local.room.CatalogueDao;
import id.cybershift.fakhrimovie.data.source.local.room.CatalogueDatabase;

public class LocalRepository {
    private CatalogueDao catalogueDao;
    private ExecutorService executorService;

    private static LocalRepository INSTANCE;

    private LocalRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();

        CatalogueDatabase db = CatalogueDatabase.getInstance(application);
        catalogueDao = db.catalogueDao();
    }

    public static LocalRepository getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(application);
        }
        return INSTANCE;
    }

    //    public LiveData<List<FavoriteEntity>> getAllFavoriteMovie() {
//        return catalogueDao.getAllFavoriteMovie();
//    }
    public DataSource.Factory<Integer, FavoriteEntity> getAllFavoriteMovieAsPaged() {
        return catalogueDao.getAllFavoriteMovieAsPaged();
    }

//    public LiveData<List<FavoriteEntity>> getAllFavoriteTVShow() {
//        return catalogueDao.getAllFavoriteTVShow();
//    }

    public DataSource.Factory<Integer, FavoriteEntity> getAllFavoriteTVShowAsPaged() {
        return catalogueDao.getAllFavoriteTVShowAsPaged();
    }

    public void insertFavorite(final FavoriteEntity favoriteEntity) {
        executorService.execute(() -> catalogueDao.insertFavorite(favoriteEntity));
    }

    public void deleteFavorite(final FavoriteEntity favoriteEntity) {
        executorService.execute(() -> catalogueDao.deleteFavorite(favoriteEntity));
    }
}

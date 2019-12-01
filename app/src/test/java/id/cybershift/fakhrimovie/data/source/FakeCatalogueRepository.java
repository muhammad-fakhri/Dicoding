package id.cybershift.fakhrimovie.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import id.cybershift.fakhrimovie.data.source.local.LocalRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.remote.RemoteRepository;
import id.cybershift.fakhrimovie.data.source.remote.response.MovieResponse;
import id.cybershift.fakhrimovie.data.source.remote.response.TVShowResponse;

public class FakeCatalogueRepository implements CatalogueDataSource {
    private volatile static FakeCatalogueRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;
    private final LocalRepository localRepository;

    FakeCatalogueRepository(@NonNull RemoteRepository remoteRepository, @NonNull LocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    public static FakeCatalogueRepository getInstance(RemoteRepository remoteData, LocalRepository localRepository) {
        if (INSTANCE == null) {
            synchronized (FakeCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeCatalogueRepository(remoteData, localRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<ArrayList<MovieEntity>> getAllMovies() {
        MutableLiveData<ArrayList<MovieEntity>> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    MovieEntity movie = new MovieEntity(
                            response.getTitle(),
                            response.getOverview(),
                            response.getRate(),
                            response.getYear(),
                            response.getPoster()
                    );
                    movieList.add(movie);
                }
                movieResult.postValue(movieList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return movieResult;
    }

    @Override
    public LiveData<ArrayList<TVShowEntity>> getAllTVShows() {
        MutableLiveData<ArrayList<TVShowEntity>> tvshowResult = new MutableLiveData<>();

        remoteRepository.getAllTVShows(new RemoteRepository.LoadTVShowCallback() {
            @Override
            public void onAllTVShowReceived(List<TVShowResponse> tvShowResponses) {
                ArrayList<TVShowEntity> tvshowList = new ArrayList<>();
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TVShowResponse response = tvShowResponses.get(i);
                    TVShowEntity tvshow = new TVShowEntity(
                            response.getTitle(),
                            response.getOverview(),
                            response.getRate(),
                            response.getYear(),
                            response.getPoster()
                    );
                    tvshowList.add(tvshow);
                }
                tvshowResult.postValue(tvshowList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

        return tvshowResult;
    }

    @Override
    public LiveData<MovieEntity> getMovie(int position) {
        MutableLiveData<MovieEntity> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieResponse> movieResponses) {
                MovieResponse response = movieResponses.get(position);
                MovieEntity movieEntity = new MovieEntity(
                        response.getTitle(),
                        response.getOverview(),
                        response.getRate(),
                        response.getYear(),
                        response.getPoster()
                );
                movieResult.postValue(movieEntity);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return movieResult;

    }

    @Override
    public LiveData<TVShowEntity> getTVShow(int position) {
        MutableLiveData<TVShowEntity> tvshowResult = new MutableLiveData<>();
        remoteRepository.getAllTVShows(new RemoteRepository.LoadTVShowCallback() {
            @Override
            public void onAllTVShowReceived(List<TVShowResponse> tvShowResponses) {
                TVShowResponse response = tvShowResponses.get(position);
                TVShowEntity tvShowEntity = new TVShowEntity(
                        response.getTitle(),
                        response.getOverview(),
                        response.getRate(),
                        response.getYear(),
                        response.getPoster()
                );
                tvshowResult.postValue(tvShowEntity);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
        return tvshowResult;
    }

    @Override
    public LiveData<List<FavoriteEntity>> getAllFavoriteMovie() {
        return localRepository.getAllFavoriteMovie();
    }

    @Override
    public LiveData<List<FavoriteEntity>> getAllFavoriteTVShow() {
        return localRepository.getAllFavoriteTVShow();
    }

    @Override
    public void insertFavorite(FavoriteEntity favoriteEntity) {
        localRepository.insertFavorite(favoriteEntity);
    }

    @Override
    public void deleteFavorite(FavoriteEntity favoriteEntity) {
        localRepository.deleteFavorite(favoriteEntity);
    }
}

package id.cybershift.fakhrimovie.data.source.remote;

import android.os.Handler;

import java.util.List;

import id.cybershift.fakhrimovie.data.source.remote.response.MovieResponse;
import id.cybershift.fakhrimovie.data.source.remote.response.TVShowResponse;
import id.cybershift.fakhrimovie.utils.DataSource;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private DataSource dataSource;

    public RemoteRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RemoteRepository getInstance(DataSource dataSource) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(dataSource);
        }
        return INSTANCE;
    }

    public void getAllMovies(final LoadMoviesCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(() -> callback.onAllMoviesReceived(dataSource.getMoviesData()), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllTVShows(LoadTVShowCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(() -> callback.onAllTVShowReceived(dataSource.getTVShowsData()), SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMoviesCallback {
        void onAllMoviesReceived(List<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadTVShowCallback {
        void onAllTVShowReceived(List<TVShowResponse> tvShowResponses);

        void onDataNotAvailable();
    }
}

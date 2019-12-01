package id.cybershift.fakhrimovie.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import id.cybershift.fakhrimovie.data.source.local.LocalRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.remote.RemoteRepository;
import id.cybershift.fakhrimovie.data.source.remote.response.MovieResponse;
import id.cybershift.fakhrimovie.data.source.remote.response.TVShowResponse;
import id.cybershift.fakhrimovie.utils.FakeDataSource;
import id.cybershift.fakhrimovie.utils.LiveDataTestUtils;
import id.cybershift.fakhrimovie.utils.PagedListUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository localRepository = Mockito.mock(LocalRepository.class);
    private RemoteRepository remoteRepository = Mockito.mock(RemoteRepository.class);
    private FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(remoteRepository, localRepository);

    private ArrayList<MovieResponse> movieResponses = FakeDataSource.getMoviesData();
    private MovieEntity movieEntity = FakeDataSource.getMovie(0);
    private ArrayList<TVShowResponse> tvShowResponses = FakeDataSource.getTVShowsData();
    private TVShowEntity tvShowEntity = FakeDataSource.getTVShow(1);
//    private List<FavoriteEntity>

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllMovies() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteRepository).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));
        ArrayList<MovieEntity> result = LiveDataTestUtils.getValue(catalogueRepository.getAllMovies());
        verify(remoteRepository, times(1)).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));
        assertNotNull(result);
        assertEquals(movieResponses.size(), movieResponses.size());
    }

    @Test
    public void getAllTVShows() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTVShowCallback) invocation.getArguments()[0]).onAllTVShowReceived(tvShowResponses);
            return null;
        }).when(remoteRepository).getAllTVShows(any(RemoteRepository.LoadTVShowCallback.class));
        ArrayList<TVShowEntity> result = LiveDataTestUtils.getValue(catalogueRepository.getAllTVShows());
        verify(remoteRepository, times(1)).getAllTVShows(any(RemoteRepository.LoadTVShowCallback.class));
        assertNotNull(result);
        assertEquals(tvShowResponses.size(), result.size());
    }

    @Test
    public void getMovie() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteRepository).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));
        MovieEntity movie = LiveDataTestUtils.getValue(catalogueRepository.getMovie(0));
        verify(remoteRepository, times(1)).getAllMovies(any(RemoteRepository.LoadMoviesCallback.class));
        assertNotNull(movie);
        assertEquals(movieEntity.getTitle(), movie.getTitle());
        assertEquals(movieEntity.getOverview(), movie.getOverview());
        assertEquals(movieEntity.getYear(), movie.getYear());
        assertEquals(String.valueOf(movieEntity.getRate()), String.valueOf(movie.getRate()));
        assertEquals(movieEntity.getPoster(), movie.getPoster());
    }

    @Test
    public void getTVShow() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTVShowCallback) invocation.getArguments()[0]).onAllTVShowReceived(tvShowResponses);
            return null;
        }).when(remoteRepository).getAllTVShows(any(RemoteRepository.LoadTVShowCallback.class));
        TVShowEntity tvshow = LiveDataTestUtils.getValue(catalogueRepository.getTVShow(1));
        verify(remoteRepository, times(1)).getAllTVShows(any(RemoteRepository.LoadTVShowCallback.class));
        assertNotNull(tvshow);
        assertEquals(tvShowEntity.getTitle(), tvshow.getTitle());
        assertEquals(tvShowEntity.getOverview(), tvshow.getOverview());
        assertEquals(tvShowEntity.getYear(), tvshow.getYear());
        assertEquals(String.valueOf(tvShowEntity.getRate()), String.valueOf(tvshow.getRate()));
        assertEquals(tvShowEntity.getPoster(), tvshow.getPoster());
    }

    @Test
    public void getAllFavoriteMovie() {
        ArrayList<MovieEntity> movies = FakeDataSource.generateDummyRemoteMovies();
        List<FavoriteEntity> favoriteMovie = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            MovieEntity item = movies.get(i);
            favoriteMovie.add(new FavoriteEntity(
                    item.getTitle(),
                    item.getOverview(),
                    item.getRate(),
                    item.getYear(),
                    item.getPoster(),
                    0
            ));
        }
        DataSource.Factory<Integer, FavoriteEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localRepository.getAllFavoriteMovieAsPaged()).thenReturn(dataSourceFactory);
        catalogueRepository.getAllFavoriteMovie();
        PagedList<FavoriteEntity> result = PagedListUtil.mockPagedList(favoriteMovie);
        verify(localRepository).getAllFavoriteMovieAsPaged();
        assertNotNull(result);
        assertEquals(movies.size(), result.size());
    }

    @Test
    public void getAllFavoriteTVShow() {
        ArrayList<TVShowEntity> tvshows = FakeDataSource.generateDummyRemoteTVShows();
        List<FavoriteEntity> favoriteTVShow = new ArrayList<>();
        for (int i = 0; i < tvshows.size(); i++) {
            TVShowEntity item = tvshows.get(i);
            favoriteTVShow.add(new FavoriteEntity(
                    item.getTitle(),
                    item.getOverview(),
                    item.getRate(),
                    item.getYear(),
                    item.getPoster(),
                    0
            ));
        }
        DataSource.Factory<Integer, FavoriteEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localRepository.getAllFavoriteTVShowAsPaged()).thenReturn(dataSourceFactory);
        catalogueRepository.getAllFavoriteTVShow();
        PagedList<FavoriteEntity> result = PagedListUtil.mockPagedList(favoriteTVShow);
        verify(localRepository).getAllFavoriteTVShowAsPaged();
        assertNotNull(result);
        assertEquals(tvshows.size(), result.size());
    }
}
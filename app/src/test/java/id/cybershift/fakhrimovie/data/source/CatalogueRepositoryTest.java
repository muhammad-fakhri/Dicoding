package id.cybershift.fakhrimovie.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.remote.RemoteRepository;
import id.cybershift.fakhrimovie.data.source.remote.response.MovieResponse;
import id.cybershift.fakhrimovie.data.source.remote.response.TVShowResponse;
import id.cybershift.fakhrimovie.utils.FakeDataSource;
import id.cybershift.fakhrimovie.utils.LiveDataTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository remoteRepository = Mockito.mock(RemoteRepository.class);
    private FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(remoteRepository);

    private ArrayList<MovieResponse> movieResponses = FakeDataSource.getMoviesData();
    private MovieEntity movieEntity = FakeDataSource.getMovie(0);
    private ArrayList<TVShowResponse> tvShowResponses = FakeDataSource.getTVShowsData();
    private TVShowEntity tvShowEntity = FakeDataSource.getTVShow(1);

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
}
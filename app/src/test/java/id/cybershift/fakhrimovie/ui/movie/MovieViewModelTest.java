package id.cybershift.fakhrimovie.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.utils.FakeDataSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        ArrayList<MovieEntity> dummyMovies = FakeDataSource.generateDummyRemoteMovies();
        MutableLiveData<ArrayList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(catalogueRepository.getAllMovies()).thenReturn(movies);

        Observer<ArrayList<MovieEntity>> observer = mock(Observer.class);

        viewModel.getMovies().observeForever(observer);

        verify(observer).onChanged(dummyMovies);
    }
}
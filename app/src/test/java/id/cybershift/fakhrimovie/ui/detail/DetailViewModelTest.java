package id.cybershift.fakhrimovie.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.utils.FakeDataSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailViewModel viewModel;
    private MovieEntity dummyMovie = FakeDataSource.generateDummyRemoteMovies().get(0);
    private TVShowEntity dummyTVShow = FakeDataSource.generateDummyRemoteTVShows().get(1);
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new DetailViewModel(catalogueRepository);
    }

    @Test
    public void getMovieByPosition() {
        MutableLiveData<MovieEntity> movieEntityMutableLiveData = new MutableLiveData<>();
        movieEntityMutableLiveData.setValue(dummyMovie);

        when(catalogueRepository.getMovie(0)).thenReturn(movieEntityMutableLiveData);

        Observer<MovieEntity> observer = mock(Observer.class);
        viewModel.setPosition(0);
        viewModel.getMovieByPosition().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void getTVShowByPosition() {
        MutableLiveData<TVShowEntity> tvShowEntityMutableLiveData = new MutableLiveData<>();
        tvShowEntityMutableLiveData.setValue(dummyTVShow);

        when(catalogueRepository.getTVShow(1)).thenReturn(tvShowEntityMutableLiveData);

        Observer<TVShowEntity> observer = mock(Observer.class);
        viewModel.setPosition(1);
        viewModel.getTVShowByPosition().observeForever(observer);

        verify(observer).onChanged(dummyTVShow);
    }

}
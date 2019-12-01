package id.cybershift.fakhrimovie.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.utils.FakeDataSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TVShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TVShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new TVShowViewModel(catalogueRepository);
    }

    @Test
    public void getTVShows() {
        ArrayList<TVShowEntity> dummyTVShows = FakeDataSource.generateDummyRemoteTVShows();
        MutableLiveData<ArrayList<TVShowEntity>> tvshows = new MutableLiveData<>();
        tvshows.setValue(dummyTVShows);

        when(catalogueRepository.getAllTVShows()).thenReturn(tvshows);
        Observer<ArrayList<TVShowEntity>> observer = mock(Observer.class);
        viewModel.getTVShows().observeForever(observer);
        verify(observer).onChanged(dummyTVShows);
    }

}
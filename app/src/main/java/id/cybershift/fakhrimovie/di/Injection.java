package id.cybershift.fakhrimovie.di;

import android.app.Application;

import id.cybershift.fakhrimovie.data.source.CatalogueRepository;
import id.cybershift.fakhrimovie.data.source.local.LocalRepository;
import id.cybershift.fakhrimovie.data.source.local.room.CatalogueDao;
import id.cybershift.fakhrimovie.data.source.remote.RemoteRepository;
import id.cybershift.fakhrimovie.utils.DataSource;

public class Injection {
    public static CatalogueRepository provideRepository(Application application) {
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new DataSource(application));
        LocalRepository localRepository = LocalRepository.getInstance(application);
        return CatalogueRepository.getInstance(remoteRepository, localRepository);
    }
}

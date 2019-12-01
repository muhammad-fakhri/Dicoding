package id.cybershift.fakhrimovie.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

@Database(entities = {FavoriteEntity.class}, version = 1, exportSchema = false)
public abstract class CatalogueDatabase extends RoomDatabase {
    public abstract CatalogueDao catalogueDao();

    private static volatile CatalogueDatabase INSTANCE;

    public static CatalogueDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CatalogueDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CatalogueDatabase.class, "fakhri_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

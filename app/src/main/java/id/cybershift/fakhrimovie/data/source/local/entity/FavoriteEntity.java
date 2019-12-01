package id.cybershift.fakhrimovie.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite")
public class FavoriteEntity implements Parcelable {
    public static final Creator<FavoriteEntity> CREATOR = new Creator<FavoriteEntity>() {
        @Override
        public FavoriteEntity createFromParcel(Parcel in) {
            return new FavoriteEntity(in);
        }

        @Override
        public FavoriteEntity[] newArray(int size) {
            return new FavoriteEntity[size];
        }
    };
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "overview")
    private String overview;
    @ColumnInfo(name = "rate")
    private double rate;
    @ColumnInfo(name = "year")
    private String year;
    @ColumnInfo(name = "poster")
    private String poster;
    @ColumnInfo(name = "type")
    private int type;

    public FavoriteEntity(String title, String overview, double rate, String year, String poster, int type) {
        this.title = title;
        this.overview = overview;
        this.rate = rate;
        this.year = year;
        this.poster = poster;
        this.type = type;
    }

    protected FavoriteEntity(Parcel in) {
        title = in.readString();
        overview = in.readString();
        rate = in.readDouble();
        year = in.readString();
        poster = in.readString();
        type = in.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeDouble(rate);
        dest.writeString(year);
        dest.writeString(poster);
        dest.writeInt(type);
    }
}

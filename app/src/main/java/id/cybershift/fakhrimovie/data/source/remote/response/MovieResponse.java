package id.cybershift.fakhrimovie.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
    private String title;
    private String overview;
    private double rate;
    private String year;
    private String poster;

    public MovieResponse(String title, String overview, double rate, String year, String poster) {
        this.title = title;
        this.overview = overview;
        this.rate = rate;
        this.year = year;
        this.poster = poster;
    }

    protected MovieResponse(Parcel in) {
        title = in.readString();
        overview = in.readString();
        rate = in.readDouble();
        year = in.readString();
        poster = in.readString();
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
    }
}

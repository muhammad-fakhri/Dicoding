package id.cybershift.fakhrimovie.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShowResponse implements Parcelable {
    public static final Creator<TVShowResponse> CREATOR = new Creator<TVShowResponse>() {
        @Override
        public TVShowResponse createFromParcel(Parcel in) {
            return new TVShowResponse(in);
        }

        @Override
        public TVShowResponse[] newArray(int size) {
            return new TVShowResponse[size];
        }
    };
    private String title;
    private String overview;
    private double rate;
    private String year;
    private String poster;

    public TVShowResponse(String title, String overview, double rate, String year, String poster) {
        this.title = title;
        this.overview = overview;
        this.rate = rate;
        this.year = year;
        this.poster = poster;
    }

    protected TVShowResponse(Parcel in) {
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

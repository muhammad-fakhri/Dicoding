package id.cybershift.fakhrimovie.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.ui.detail.DetailActivity;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<MovieEntity> listMovies = new ArrayList<>();
    private Activity activity = new Activity();

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setListMovies(ArrayList<MovieEntity> listMovies) {
        if (listMovies != null) {
            this.listMovies.clear();
            this.listMovies.addAll(listMovies);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(listMovies.get(position), holder, position);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvName, tvDescription;
        Button favoriteBtn;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.item_poster);
            tvName = itemView.findViewById(R.id.item_name);
            tvDescription = itemView.findViewById(R.id.item_description);
            favoriteBtn = itemView.findViewById(R.id.favorite_button);
        }

        void bind(MovieEntity movieItem, MovieViewHolder viewHolder, final int position) {
            Glide.with(viewHolder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w185" + movieItem.getPoster())
                    .apply(new RequestOptions().override(200, 250))
                    .into(viewHolder.imgPoster);
            tvName.setText(movieItem.getTitle());
            tvDescription.setText(movieItem.getOverview());
            favoriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //masukin data ke database pakai room
                    Toast.makeText(activity, "PENCET TOMBOL FAVORITE", Toast.LENGTH_SHORT).show();
                }
            });

            //Set click listener
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_ITEM_TYPE, "movie");
                    intent.putExtra(DetailActivity.EXTRA_ITEM_POSITION, position);
                    activity.startActivity(intent);
                }
            });
        }
    }
}

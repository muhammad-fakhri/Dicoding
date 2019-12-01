package id.cybershift.fakhrimovie.ui.favorite.tvshowfavorite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

public class FavoriteTVShowAdapter extends RecyclerView.Adapter<FavoriteTVShowAdapter.FavoriteTVShowViewHolder> {
    private ArrayList<FavoriteEntity> listFavorites = new ArrayList<>();
    private Activity activity = new Activity();
    private FavoriteTVShowViewModel viewModel;

    public void setViewModel(FavoriteTVShowViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setListFavorites(List<FavoriteEntity> listFavorites) {
        if (listFavorites != null) {
            this.listFavorites.clear();
            this.listFavorites.addAll(listFavorites);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public FavoriteTVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        return new FavoriteTVShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTVShowViewHolder holder, int position) {
        holder.bind(listFavorites.get(position), holder, position);
    }

    @Override
    public int getItemCount() {
        return listFavorites.size();
    }

    class FavoriteTVShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvName, tvDescription;
        Button unfavoriteBtn;

        FavoriteTVShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.item_poster);
            tvName = itemView.findViewById(R.id.item_name);
            tvDescription = itemView.findViewById(R.id.item_description);
            unfavoriteBtn = itemView.findViewById(R.id.unfavorite_btn);
        }

        void bind(FavoriteEntity favoriteItem, FavoriteTVShowViewHolder viewHolder, final int position) {
            Glide.with(viewHolder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w185" + favoriteItem.getPoster())
                    .apply(new RequestOptions().override(200, 250))
                    .into(viewHolder.imgPoster);
            tvName.setText(favoriteItem.getTitle());
            tvDescription.setText(favoriteItem.getOverview());
            unfavoriteBtn.setOnClickListener(v -> viewModel.deleteFavoriteTVShow(favoriteItem));

        }
    }
}

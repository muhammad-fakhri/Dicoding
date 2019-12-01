package id.cybershift.fakhrimovie.ui.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;
import id.cybershift.fakhrimovie.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM_TYPE = "extra_item_type";
    public static final String EXTRA_ITEM_POSITION = "extra_item_position";
    ImageView detailPoster;
    TextView detailName, detailYear, detailRate, detailDescription;
    private DetailViewModel viewModel;
    private ProgressBar progressBar;
    private Button btnFavorite;

    @NonNull
    private static DetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Casting View
        detailPoster = findViewById(R.id.detail_poster);
        detailName = findViewById(R.id.detail_name);
        detailRate = findViewById(R.id.detail_rate);
        detailYear = findViewById(R.id.detail_year);
        detailDescription = findViewById(R.id.detail_description);

        btnFavorite = findViewById(R.id.favorite_btn);

        progressBar = findViewById(R.id.detail_pb);
        progressBar.setVisibility(View.VISIBLE);

        viewModel = obtainViewModel(this);
        viewModel.setPosition(getIntent().getExtras().getInt(EXTRA_ITEM_POSITION));

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().getExtras().getString(EXTRA_ITEM_TYPE).equals("movie")) {
            viewModel.getMovieByPosition().observe(this, movieEntity -> {
                if (movieEntity != null) {
                    progressBar.setVisibility(View.GONE);
                }
                detailName.setText(movieEntity.getTitle());
                detailRate.setText(String.valueOf(movieEntity.getRate()));
                detailYear.setText(movieEntity.getYear());
                detailDescription.setText(movieEntity.getOverview());
                Glide.with(this)
                        .load("https://image.tmdb.org/t/p/w185" + movieEntity.getPoster())
                        .apply(new RequestOptions().override(200, 250))
                        .into(detailPoster);

                btnFavorite.setOnClickListener(v -> {
                    Toast.makeText(DetailActivity.this, "Favorite " + movieEntity.getTitle(), Toast.LENGTH_SHORT).show();
                    viewModel.insertFavorite(new FavoriteEntity(
                            movieEntity.getTitle(),
                            movieEntity.getOverview(),
                            movieEntity.getRate(),
                            movieEntity.getYear(),
                            movieEntity.getPoster(),
                            0
                    ));
                });
            });

        } else if (getIntent().getExtras().getString(EXTRA_ITEM_TYPE).equals("tv")) {
            viewModel.getTVShowByPosition().observe(this, tvshowEntity -> {
                if (tvshowEntity != null) {
                    progressBar.setVisibility(View.GONE);
                }
                detailName.setText(tvshowEntity.getTitle());
                detailRate.setText(String.valueOf(tvshowEntity.getRate()));
                detailYear.setText(tvshowEntity.getYear());
                detailDescription.setText(tvshowEntity.getOverview());
                Glide.with(this)
                        .load("https://image.tmdb.org/t/p/w185" + tvshowEntity.getPoster())
                        .apply(new RequestOptions().override(200, 250))
                        .into(detailPoster);

                btnFavorite.setOnClickListener(v -> {
                    Toast.makeText(DetailActivity.this, "Favorite " + tvshowEntity.getTitle(), Toast.LENGTH_SHORT).show();
                    viewModel.insertFavorite(new FavoriteEntity(
                            tvshowEntity.getTitle(),
                            tvshowEntity.getOverview(),
                            tvshowEntity.getRate(),
                            tvshowEntity.getYear(),
                            tvshowEntity.getPoster(),
                            1
                    ));
                });
            });

        } else {
            Toast.makeText(this, "GAGAL LOAD DATA DETAIL", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

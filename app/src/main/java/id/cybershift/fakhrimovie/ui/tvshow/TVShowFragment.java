package id.cybershift.fakhrimovie.ui.tvshow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {
    private TVShowAdapter adapter;
    private RecyclerView rvTVShow;
    private TVShowViewModel viewModel;
    private ArrayList<TVShowEntity> tvshows = new ArrayList<>();
    private ProgressBar progressBar;

    public TVShowFragment() {
        // Required empty public constructor
    }

    @NonNull
    private static TVShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TVShowViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTVShow = view.findViewById(R.id.tvshow_rv);
        progressBar = view.findViewById(R.id.tvshow_pb);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressBar.setVisibility(View.VISIBLE);
        if (getActivity() != null) {
            adapter = new TVShowAdapter();
            adapter.setActivity(this.getActivity());

            viewModel = obtainViewModel(getActivity());
            viewModel.getTVShows().observe(this, tvshows -> {
                progressBar.setVisibility(View.GONE);
                adapter.setListTVShows(tvshows);
                adapter.notifyDataSetChanged();
            });

            rvTVShow.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTVShow.setHasFixedSize(true);
            rvTVShow.setAdapter(adapter);
        }
    }
}

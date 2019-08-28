package com.sincerelylab.kindo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sincerelylab.kindo.R;
import com.sincerelylab.kindo.data.remote.APIService;
import com.sincerelylab.kindo.data.remote.ApiClient;
import com.sincerelylab.kindo.data.repositories.FeedPageDataSourceFactory;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private RecyclerView rvFeeds;
    private HomeFragmentViewModel homeFragmentViewModel;
    private FeedsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Need dependency injector
        APIService service = ApiClient.getService();

        FeedPageDataSourceFactory feedPageDataSourceFactory = new FeedPageDataSourceFactory(service, "home");

        homeFragmentViewModel = ViewModelProviders.of(
                this,
                new HomeFragmentViewModelFactory(feedPageDataSourceFactory)).get(HomeFragmentViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFeeds = view.findViewById(R.id.rv_feeds);
        rvFeeds.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        adapter = new FeedsAdapter();
        rvFeeds.setAdapter(adapter);
        homeFragmentViewModel.getFeedPagedList().observe(this, feeds -> adapter.submitList(feeds));
    }
}

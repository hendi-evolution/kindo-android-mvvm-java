package com.sincerelylab.kindo.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.sincerelylab.kindo.data.repositories.FeedPageDataSourceFactory;

public class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {

    private FeedPageDataSourceFactory feedPageDataSourceFactory;

    public HomeFragmentViewModelFactory(FeedPageDataSourceFactory feedPageDataSourceFactory) {
        this.feedPageDataSourceFactory = feedPageDataSourceFactory;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel.class)) {
            return (T) new HomeFragmentViewModel(feedPageDataSourceFactory);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

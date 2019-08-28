package com.sincerelylab.kindo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.sincerelylab.kindo.data.db.entities.Feed;
import com.sincerelylab.kindo.data.repositories.FeedPageDataSourceFactory;

public class HomeFragmentViewModel extends ViewModel {

    private LiveData<PagedList<Feed>> feedPagedList;

    public HomeFragmentViewModel(FeedPageDataSourceFactory feedPageDataSourceFactory){

        PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setPageSize(10)
                        .build();

        feedPagedList = new LivePagedListBuilder<Long, Feed>(feedPageDataSourceFactory, pagedListConfig).build();
    }

    public LiveData<PagedList<Feed>> getFeedPagedList(){
        return feedPagedList;
    }

}

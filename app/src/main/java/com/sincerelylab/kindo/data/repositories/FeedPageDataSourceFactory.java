package com.sincerelylab.kindo.data.repositories;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;

import com.sincerelylab.kindo.data.db.entities.Feed;
import com.sincerelylab.kindo.data.remote.APIService;

public class FeedPageDataSourceFactory extends DataSource.Factory {

    private APIService apiService;
    private String category;
    private MutableLiveData<ItemKeyedDataSource<Long, Feed>> feedsLiveDataSource = new MutableLiveData<>();

    public FeedPageDataSourceFactory(APIService apiService, String category){
        this.apiService = apiService;
        this.category = category;
    }

    @Override
    public DataSource create() {
        FeedPageDataSource dataSource = new FeedPageDataSource(apiService, category);
        feedsLiveDataSource.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<ItemKeyedDataSource<Long, Feed>> getFeedsLiveDataSource() {
        return feedsLiveDataSource;
    }
}

package com.sincerelylab.kindo.data.repositories;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import com.sincerelylab.kindo.data.db.entities.Feed;
import com.sincerelylab.kindo.data.remote.APIService;
import com.sincerelylab.kindo.data.remote.responses.FeedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedPageDataSource extends ItemKeyedDataSource<Long, Feed> {

    private APIService apiService;
    private String category;

    public FeedPageDataSource(APIService apiService, String category){
        this.apiService = apiService;
        this.category = category;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Feed> callback) {
        apiService.getFeed(null, 0).enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                if(response.isSuccessful()){
                    callback.onResult(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Feed> callback) {
        apiService.getFeed(null, params.key).enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                if(response.isSuccessful()){
                    callback.onResult(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Feed> callback) {

    }

    @NonNull
    @Override
    public Long getKey(@NonNull Feed item) {
        return item.timestamp;
    }
}

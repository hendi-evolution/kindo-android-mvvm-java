package com.sincerelylab.kindo.data.remote;

import com.sincerelylab.kindo.data.remote.responses.FeedResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("rssV2.php")
    Call<FeedResponse> getFeed(
            @Query("category") String category,
            @Query("timestamp") long timestamp
    );
}

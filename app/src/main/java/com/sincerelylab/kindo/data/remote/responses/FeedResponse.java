package com.sincerelylab.kindo.data.remote.responses;


import com.sincerelylab.kindo.data.db.entities.Feed;

import java.util.List;

public class FeedResponse extends BaseResponse<List<Feed>> {
    public int count;
}

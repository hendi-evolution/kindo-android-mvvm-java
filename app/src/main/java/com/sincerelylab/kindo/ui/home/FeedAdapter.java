package com.sincerelylab.kindo.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.sincerelylab.kindo.data.db.entities.Feed;

import java.util.List;

public class FeedAdapter extends Adapter<FeedAdapter.FeedViewHolder> {

    private List<Feed> feedList;

    public FeedAdapter(List<Feed> feedList){
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        ((TextView)holder.itemView).setText(feedList.get(position).title);
    }

    @Override
    public int getItemCount() {
        if(feedList != null)
            return feedList.size();
        return 0;
    }


    // View Holder
    public class FeedViewHolder extends RecyclerView.ViewHolder{

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

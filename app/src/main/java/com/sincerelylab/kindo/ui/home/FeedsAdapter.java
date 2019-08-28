package com.sincerelylab.kindo.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sincerelylab.kindo.R;
import com.sincerelylab.kindo.data.db.entities.Feed;
import com.sincerelylab.kindo.databinding.ItemFeedBinding;

public class FeedsAdapter extends PagedListAdapter<Feed, FeedsAdapter.FeedsViewHolder> {

    protected FeedsAdapter() {
        super(Feed.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FeedsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFeedBinding itemFeedBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_feed, parent,
                false);

        return new FeedsViewHolder(itemFeedBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsViewHolder holder, int position) {
        Feed feed = getItem(position);
        holder.itemFeedBinding.setFeed(feed);
    }

    // View Holder
    public class FeedsViewHolder extends RecyclerView.ViewHolder{

        private ItemFeedBinding itemFeedBinding;

        public FeedsViewHolder(@NonNull ItemFeedBinding itemFeedBinding) {
            super(itemFeedBinding.getRoot());
            this.itemFeedBinding = itemFeedBinding;
        }
    }
}

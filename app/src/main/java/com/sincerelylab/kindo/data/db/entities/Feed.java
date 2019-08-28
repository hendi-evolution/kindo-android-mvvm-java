package com.sincerelylab.kindo.data.db.entities;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

public class Feed {
    public String title;
    public String link;
    public String creator;
    public long timestamp;
    public String date;
    public String img_url;

    public static DiffUtil.ItemCallback<Feed> DIFF_CALLBACK = new DiffUtil.ItemCallback<Feed>() {
        @Override
        public boolean areItemsTheSame(@NonNull Feed oldItem, @NonNull Feed newItem) {
            return oldItem.timestamp == newItem.timestamp;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Feed oldItem, @NonNull Feed newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        Feed article = (Feed) obj;
        return article.timestamp == this.timestamp;
    }


    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}

package com.example.tidings2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView news_title, news_description;
    ImageView news_thumbnail;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        news_title = itemView.findViewById(R.id.news_title);
        news_description = itemView.findViewById(R.id.news_description);
        news_thumbnail = itemView.findViewById(R.id.news_thumbnail);
        cardView = itemView.findViewById(R.id.cardView);
    }
}

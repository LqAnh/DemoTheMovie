package com.example.themovie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovie.R;
import com.example.themovie.api.model.ReviewFilmModel;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    private static final String TAG = ReviewAdapter.class.getName();
    private final List<ReviewFilmModel.Result> listData;
    private final Context context;


    public ReviewAdapter(List<ReviewFilmModel.Result> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }


    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.review_detail, parent, false);
        return new ReviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReviewHolder holder, int position) {
        ReviewFilmModel.Result data = listData.get(position);

        holder.tvAuthor.setText(data.getAuthorName());
        holder.tvContent.setText(data.getContentReview());
        holder.tvRating.setText(data.getListAuthorDetail().getRating());
        holder.tvRating.setTextColor(Color.parseColor("#FDD835"));


//        double score = Double.parseDouble(data.getListAuthorDetail().getRating());
//        if (score >= 8) {
//            holder.tvRating.setTextColor(Color.parseColor("#4FAC53"));
//        } else if (score < 8){
//            holder.tvRating.setTextColor(Color.parseColor("#FDD835"));
//
//        }


        Glide.with(context)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + data.getListAuthorDetail().getAvaAuthor())
                .into(holder.imAuthor);

        Log.i(TAG, "onBindViewHolder: ......." + data.getListAuthorDetail().getAvaAuthor());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ReviewHolder extends RecyclerView.ViewHolder {
        TextView tvAuthor, tvContent, tvRating;
        ImageView imAuthor;


        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvContent = itemView.findViewById(R.id.tv_review);
            tvRating = itemView.findViewById(R.id.tv_rating);
            imAuthor = itemView.findViewById(R.id.im_author);
        }
    }
}

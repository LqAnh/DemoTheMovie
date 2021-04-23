package com.example.themovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themovie.R;
import com.example.themovie.api.model.MovieModel;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {
    private final List<MovieModel.Result> listData;
    private final Context context;
    private OnItemClick mCallBack;

    public FilmAdapter(List<MovieModel.Result> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmAdapter.FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movie_detail, parent,false);
        return new FilmHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmHolder holder, int position) {


        MovieModel.Result data = listData.get(position);
        Glide.with(context)
                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + data.getBackDropPath())
                .into(holder.ivMovie);
        holder.tvTitle.setText(data.getTitle());
        holder.tvDate.setText(data.getReleaseDate());
        holder.tvOverview.setText(data.getOverview());

        holder.pos = position;
        holder.film = data;

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public interface OnItemClick{
        void onItemClick(MovieModel.Result film);
    }

    public void setmCallBack(OnItemClick mCallBack) {
        this.mCallBack = mCallBack;
    }

    public class FilmHolder extends RecyclerView.ViewHolder{
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvDate;
        TextView tvOverview;
        LinearLayout lnItem;
        private MovieModel.Result film;
        private int pos;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);



            ivMovie = itemView.findViewById(R.id.iv_photo);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvOverview = itemView.findViewById(R.id.tv_overview);

            lnItem = itemView.findViewById(R.id.ln_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCallBack != null){
                        mCallBack.onItemClick(film);
                    }
                }
            });
        }
    }


}

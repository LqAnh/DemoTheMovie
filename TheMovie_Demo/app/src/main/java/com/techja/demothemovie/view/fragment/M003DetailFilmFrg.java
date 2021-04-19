package com.techja.demothemovie.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.techja.demothemovie.App;
import com.techja.demothemovie.R;
import com.techja.demothemovie.api.model.DetailMovieModel;
import com.techja.demothemovie.api.model.MovieModel;
import com.techja.demothemovie.api.model.TrailerFilmModel;
import com.techja.demothemovie.view.act.YoutubeDialog;
import com.techja.demothemovie.view.viewmodel.M003DetailModel;

public class M003DetailFilmFrg extends BaseFragment<M003DetailModel> {
    private static final String TAG = M003DetailFilmFrg.class.getName();
    private MovieModel.Result film;
    private TextView tvTitle, tvTime, tvUserRate, tvDate, tvOverview;
    private ImageView posHori, posVer;

    private Button btTrailer;


    public void setFilm(MovieModel.Result film) {
        this.film = film;
    }


    @Override
    protected void initViews() {
        tvTime = findViewById(R.id.tv_time);
        tvTitle = findViewById(R.id.tv_title);
        tvUserRate = findViewById(R.id.tv_user_rate);
        tvDate = findViewById(R.id.tv_date);
        tvOverview = findViewById(R.id.tv_detail);

        posHori = findViewById(R.id.iv_pos_hori);
        posVer = findViewById(R.id.iv_pos_ver);

        btTrailer = findViewById(R.id.bt_trailer);
        btTrailer.setOnClickListener(this);

        mModel.getDetailMovie(film.getId());

    }

    @Override
    protected void clickView(View v, int id) {
        if (v.getId() == R.id.bt_trailer) {
            showTrailer();
        }
    }

    private void showTrailer() {
        Intent intent = new Intent();
        Intent intent1 = intent.setClass(App.getInstance(), YoutubeDialog.class);
        startActivity(intent);

    }

    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(M003DetailModel.KEY_NOTIFY)) {
            notify((String) data);

        } else if (key.equals(M003DetailModel.API_KEY_DETAIL_FILM)) {
            DetailMovieModel detailMovieModel = (DetailMovieModel) data;

            tvTitle.setText(detailMovieModel.getTitle());
            tvTime.setText(detailMovieModel.getRunTime() + "minutes");
            tvUserRate.setText(detailMovieModel.getVoteAverage());
            tvDate.setText(detailMovieModel.getReleaseDate());
            tvOverview.setText(detailMovieModel.getOverview());


            Glide.with(App.getInstance())
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + ((DetailMovieModel) data).getBackDropPath())
                    .into(posHori);

            Glide.with(App.getInstance())
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + ((DetailMovieModel) data).getPosterPath())
                    .into(posVer);


        }else if (key.equals(M003DetailModel.API_KEY_TRAILER_FILM)){
            TrailerFilmModel trailerFilmModel = (TrailerFilmModel) data;
            if (trailerFilmModel.getType().equals("trailer")){

            }

        }


    }

    @Override
    protected Class<M003DetailModel> getClassViewModel() {
        return M003DetailModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m003_detail;
    }


}

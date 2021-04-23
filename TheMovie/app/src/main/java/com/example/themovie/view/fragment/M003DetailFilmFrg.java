package com.example.themovie.view.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.themovie.App;
import com.example.themovie.R;
import com.example.themovie.api.model.DetailMovieModel;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.view.viewmodel.M003DetailModel;


public class M003DetailFilmFrg extends BaseFragment<M003DetailModel> {
    private static final String TAG = M003DetailFilmFrg.class.getName();
    public static final String KEY_SHOW_TRAILER = "KEY_SHOW_TRAILER";
    private MovieModel.Result film;
    private TextView tvTitle, tvTime, tvUserRate, tvDate, tvOverview, tvLanguage, tvTagLine;
    private ImageView posHori, posVer;


    private TextView tvGenres;

    private TextView tvTrailer, tvBooking;


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
        tvLanguage = findViewById(R.id.tv_language);

        posHori = findViewById(R.id.iv_pos_hori);
        posVer = findViewById(R.id.iv_pos_ver);

        tvTrailer = findViewById(R.id.tv_play_trailer);
        tvTrailer.setOnClickListener(this);


        tvGenres = findViewById(R.id.tv_gene);
        tvTagLine = findViewById(R.id.tv_tagline);

        tvBooking = findViewById(R.id.tv_booking_ticket);
        tvBooking.setOnClickListener(this);


        mModel.getDetailMovie(film.getId());


    }

    @Override
    protected void clickView(View v, int id) {
        if (v.getId() == R.id.tv_play_trailer) {
            goToM004();
        }
    }

    private void goToM004() {
        callBack.onCallBack(KEY_SHOW_TRAILER, film);
    }


    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(M003DetailModel.KEY_NOTIFY)) {
            notify((String) data);

        } else if (key.equals(M003DetailModel.API_KEY_DETAIL_FILM)) {
            DetailMovieModel detailMovieModel = (DetailMovieModel) data;

            tvTitle.setText(detailMovieModel.getTitle());
            tvTime.setText(detailMovieModel.getRunTime() + " minutes");


            double score = Double.parseDouble(detailMovieModel.getVoteAverage());
            if (score >= 8) {
                tvUserRate.setTextColor(Color.parseColor("#4FAC53"));
            } else {
                tvUserRate.setTextColor(Color.parseColor("#FDD835"));
            }

            tvUserRate.setText(detailMovieModel.getVoteAverage());


            tvDate.setText(detailMovieModel.getReleaseDate());
            tvOverview.setText(detailMovieModel.getOverview());

            switch (detailMovieModel.getLanguage()) {
                case "en":
                    tvLanguage.setText("English");
                    break;
                case "ko":
                    tvLanguage.setText("Korean");
                    break;
                case "es":
                    tvLanguage.setText("Spanish");
                    break;
                case "fr":
                    tvLanguage.setText("French");
                    break;
                case "sv":
                    tvLanguage.setText("Swedish");
                    break;
            }
            tvTagLine.setText(detailMovieModel.getTagLine());


            Glide.with(App.getInstance())
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + ((DetailMovieModel) data).getBackDropPath())
                    .into(posHori);

            Glide.with(App.getInstance())
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + ((DetailMovieModel) data).getPosterPath())
                    .into(posVer);



            int x = 0;
            while (x < detailMovieModel.getListGenres().size()) {
                DetailMovieModel.Genres dataTmp = detailMovieModel.getListGenres().get(x);
                x++;
                tvGenres.setText(dataTmp.getName());
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

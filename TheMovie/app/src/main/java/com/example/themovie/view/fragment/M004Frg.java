package com.example.themovie.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.themovie.R;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.api.model.TrailerFilmModel;
import com.example.themovie.view.viewmodel.M004TrailerFilmModel;


public class M004Frg extends BaseFragment<M004TrailerFilmModel> {
    private MovieModel.Result film;


    private static final String TAG = M004Frg.class.getName();


    public void setFilm(MovieModel.Result film) {
        this.film = film;
    }

    @Override
    protected void initViews() {
        mModel.getTrailer(film.getId());



    }

    @Override
    public void onCallBack(String key, Object data) {
        if (key.equals(M004TrailerFilmModel.KEY_NOTIFY)){
            notify((String) data);
        }else if (key.equals(M004TrailerFilmModel.API_KEY_TRAILER)){
            TrailerFilmModel trailerFilmModel = (TrailerFilmModel) data;

            Log.i(TAG, "onCallBack: TRAILER YOUTUBE VIDEO..... " +  "     " +  "https://www.youtube.com/watch?v=" + trailerFilmModel.getListResult().get(0).getKey());

            watchYoutubeVideo(trailerFilmModel.getListResult().get(0).getKey());

        }
    }
    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

    @Override
    protected Class<M004TrailerFilmModel> getClassViewModel() {
        return M004TrailerFilmModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m004_trailer;
    }


}

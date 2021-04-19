package com.techja.demothemovie.view.viewmodel;

import android.util.Log;

import com.techja.demothemovie.api.API;
import com.techja.demothemovie.api.model.DetailMovieModel;
import com.techja.demothemovie.api.model.TrailerFilmModel;

public class M003DetailModel extends BaseViewModel {
    public static final String API_KEY_TRAILER_FILM = "API_KEY_TRAILER_FILM";
    public static final String API_KEY_DETAIL_FILM = "API_KEY_DETAIL_FILM";
    private static final String TAG = M003DetailModel.class.getName();
    private DetailMovieModel detailMovieModel;
    private TrailerFilmModel trailerFilmModel;

    public void getDetailMovie(String movieId) {
        API api = getWS().create(API.class);
        api.getDetailFilm(movieId).enqueue(initHandlerRes(API_KEY_DETAIL_FILM));

    }

    @Override
    protected <T> void handleSuccess(String key, T body) {


        detailMovieModel = (DetailMovieModel) body;
        callBack.onCallBack(API_KEY_DETAIL_FILM, detailMovieModel);


    }

    @Override
    protected void handleFail(String key, Object errorBody) {
        callBack.onCallBack(KEY_NOTIFY, "Could not get detail film");
        Log.i(TAG, "handleFail: sai sai sai sai sai sai");

    }

}

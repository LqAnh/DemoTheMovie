package com.example.themovie.view.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.themovie.api.API;
import com.example.themovie.api.model.DetailMovieModel;


public class M003DetailModel extends BaseViewModel {
    public static final String API_KEY_DETAIL_FILM = "API_KEY_DETAIL_FILM";
    private static final String TAG = M003DetailModel.class.getName();
    private DetailMovieModel detailMovieModel;

    public void getDetailMovie(String movieId) {
        API api = getWS().create(API.class);
        api.getDetailFilm(movieId).enqueue(initHandlerRes(API_KEY_DETAIL_FILM));
    }


    @SuppressLint("Assert")
    @Override
    protected <T> void handleSuccess(String key, T body) {
       switch (key) {
           case API_KEY_DETAIL_FILM:
               detailMovieModel = (DetailMovieModel) body;
               callBack.onCallBack(API_KEY_DETAIL_FILM, detailMovieModel);

       }
    }


        @Override
        protected void handleFail (String key, Object errorBody){
            callBack.onCallBack(KEY_NOTIFY, "Could not get detail film");
            Log.i(TAG, "handleFail: sai sai sai sai sai sai");

        }

    }

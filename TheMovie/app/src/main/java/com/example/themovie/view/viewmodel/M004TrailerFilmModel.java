package com.example.themovie.view.viewmodel;

import android.util.Log;

import com.example.themovie.api.API;
import com.example.themovie.api.model.TrailerFilmModel;


public class M004TrailerFilmModel extends BaseViewModel {
    public static final String API_KEY_TRAILER = "API_KEY_TRAILER";
    private static final String TAG = M004TrailerFilmModel.class.getName();
    private TrailerFilmModel trailerFilmModel;



    public void getTrailer(String movieId) {
        //String filmId = App.getInstance().getId();
        API apis = getWS().create(API.class);
        apis.getLinkTrailer(movieId).enqueue(initHandlerRes(API_KEY_TRAILER));
    }

    @Override
    protected <T> void handleSuccess(String key, T body) {
        trailerFilmModel = (TrailerFilmModel) body;
        callBack.onCallBack(API_KEY_TRAILER, trailerFilmModel);
        Log.i(TAG, "handleSuccess: " + key);
        Log.i(TAG, "handleSuccess: " + body);
    }

    @Override
    protected void handleFail(String key, Object errorBody) {
        Log.e(TAG, "handleFail: " + errorBody );
    }
}

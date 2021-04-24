package com.example.themovie.view.viewmodel;

import android.util.Log;

import com.example.themovie.api.API;
import com.example.themovie.api.model.ReviewFilmModel;


public class M005FilmReviewModel extends BaseViewModel{
    public static final String API_REVIEW_FILM = "API_REVIEW_FILM" ;
    private static final String TAG = M005FilmReviewModel.class.getName();
    private ReviewFilmModel reviewFilmModel;

    public void getFilmReview(String movieId){
        API apis = getWS().create(API.class);
        apis.getReviewFilm(movieId).enqueue(initHandlerRes(API_REVIEW_FILM));
    }

    @Override
    protected <T> void handleSuccess(String key, T body) {
        reviewFilmModel = (ReviewFilmModel) body;
        callBack.onCallBack(API_REVIEW_FILM, reviewFilmModel);

    }

    @Override
    protected void handleFail(String key, Object errorBody) {
        Log.e(TAG, "handleFail:.......... REVIEW FILM FAIL FAIL " );
    }
}

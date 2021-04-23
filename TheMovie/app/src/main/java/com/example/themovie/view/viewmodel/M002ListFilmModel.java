package com.example.themovie.view.viewmodel;


import com.example.themovie.api.API;
import com.example.themovie.api.model.MovieModel;

public class M002ListFilmModel extends BaseViewModel {
    private MovieModel movieModel;
    public static final String API_KEY_LIST_FILM = "API_KEY_LIST_FILM" ;

    public void getListFilm() {
        API api = getWS().create(API.class);
        api.getListFilm().enqueue(initHandlerRes(API_KEY_LIST_FILM));
    }

    @Override
    protected <T> void handleSuccess(String key, T body) {
         movieModel = (MovieModel) body;
         callBack.onCallBack(API_KEY_LIST_FILM, movieModel);
    }

    @Override
    protected void handleFail(String key, Object errorBody) {
        callBack.onCallBack(KEY_NOTIFY, "Could not get film");
    }
}

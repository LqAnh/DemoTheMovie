package com.example.themovie.api;

import com.example.themovie.api.model.AccReqModel;
import com.example.themovie.api.model.DetailMovieModel;
import com.example.themovie.api.model.MovieModel;
import com.example.themovie.api.model.ReviewFilmModel;
import com.example.themovie.api.model.TokenResModel;
import com.example.themovie.api.model.TrailerFilmModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    String API_KEY = "8d2cc10d6d30121c3ae4048743b64da3";
    String movieId = "";
    String API_KEY_DETAIL ="791373?api_key=8d2cc10d6d30121c3ae4048743b64da3&language=en-US" ;

    @GET("authentication/token/new?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<TokenResModel> getTokenReq();

    @POST("authentication/token/validate_with_login?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<TokenResModel> login(@Body AccReqModel acc);

    @GET("discover/movie?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<MovieModel> getListFilm();

    @GET("movie/{movieId}?api_key=" + API_KEY)
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<DetailMovieModel> getDetailFilm(@Path("movieId") String movieId);


    @GET("movie/{movieId}/videos?api_key=" + API_KEY + "&language=en-US")
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<TrailerFilmModel> getLinkTrailer(@Path("movieId") String movieId);

    @GET("movie/{movieId}/reviews?api_key=" + API_KEY + "&language=en-US")
    @Headers({"Content-Type: application/json;charset=utf-8"})
    Call<ReviewFilmModel> getReviewFilm(@Path("movieId") String movieId);




}

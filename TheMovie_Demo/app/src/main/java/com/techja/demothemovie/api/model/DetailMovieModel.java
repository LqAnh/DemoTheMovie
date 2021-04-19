package com.techja.demothemovie.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class DetailMovieModel implements Serializable {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backDropPath;

    @SerializedName("original_title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("runtime")
    private String runTime;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("id")
    private String id;

//    @SerializedName("genres")
//    private List<Genres> listGenres;


//    @Getter
//    @Setter
//    private static class Genres implements Serializable {
//        @SerializedName("name")
//        private List<String> name;
//    }
}

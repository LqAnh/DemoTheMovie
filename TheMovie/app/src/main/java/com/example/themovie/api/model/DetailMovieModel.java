package com.example.themovie.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

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



    @SerializedName("genres")
    private List<Genres> listGenres;
    @Getter
    @Setter
    public static class Genres implements Serializable {

        @SerializedName("name")
        private String name;
    }
    @SerializedName("production_companies")
    private List<ProductionCP> listProductionCP;
    @Getter
    @Setter
    public static class ProductionCP implements Serializable {

        @SerializedName("name")
        private String name;
    }




    @SerializedName("production_countries")
    private List<ProductionCT> listProductionCT;
    @Getter
    @Setter
    public static class ProductionCT implements Serializable {

        @SerializedName("name")
        private String name;
    }


    @SerializedName("original_language")
    private String language;

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

    @SerializedName("tagline")
    private String tagLine;

}

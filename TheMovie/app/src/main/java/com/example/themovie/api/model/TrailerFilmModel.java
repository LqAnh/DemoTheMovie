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
public class TrailerFilmModel implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("results")
    private List<Result> listResult;

    @Getter
    @Setter
    public static class Result implements Serializable {

        @SerializedName("key")
        private String key;

    }
}

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
public class TrailerFilmModel implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("key")
    private String key;
}

package com.example.themovie.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AccReqModel implements Serializable {
    @SerializedName("username")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("request_token")
    private String requestToken;


}

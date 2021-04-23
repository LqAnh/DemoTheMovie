package com.example.themovie.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TokenResModel implements Serializable {
    @SerializedName("success")
    private boolean success;

    @SerializedName("expires_at")
    private String expiresAt;

    @SerializedName("request_token")
    private String requestToken;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    @Override
    public String toString() {
        return "TokenResModel{" +
                "success=" + success +
                ", expiresAt='" + expiresAt + '\'' +
                ", requestToken='" + requestToken + '\'' +
                '}';
    }






}

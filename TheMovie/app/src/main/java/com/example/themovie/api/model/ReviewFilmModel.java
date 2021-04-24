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
public class ReviewFilmModel implements Serializable {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<Result> listResult;

    @Getter
    @Setter
    public static class Result implements Serializable {
        @SerializedName("author")
        private String authorName;

        @SerializedName("content")
        private String contentReview;

        @Getter
        @Setter
        @SerializedName("author_details")
        private AuthorDetail listAuthorDetail;

        @Getter
        @Setter
        public static class AuthorDetail implements Serializable {
            @SerializedName("rating")
            private String rating;

            @SerializedName("avatar_path")
            private String avaAuthor;

        }
    }

}

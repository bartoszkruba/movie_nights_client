package com.example.movie_nights_client.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponseCommand {

    private String imdbID;

    private String year;

    private String rated;

    private String released;

    private String runtime;

    private String genre;

    private String director;

    private String writer;

    private String actors;

    private String plot;

    private String language;

    private String country;

    @Builder.Default
    private ArrayList<Rating> ratings = new ArrayList<>();

    private String metascore;

    private String imdbRating;

    private String imdbVotes;

    private String type;

    private String dvd;

    private String boxOffice;

    private String production;

    private String website;
}

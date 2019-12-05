package com.example.movie_nights_client.web.component;

import com.example.movie_nights_client.command.RestMovieResponseCommand;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MovieList extends VerticalLayout {

    public MovieList() {
    }

    public void add(RestMovieResponseCommand movie) {
        add(new Movie(movie));
    }
}

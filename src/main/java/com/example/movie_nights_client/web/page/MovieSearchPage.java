package com.example.movie_nights_client.web.page;

import com.example.movie_nights_client.MainLayout;
import com.example.movie_nights_client.command.RestMovieResponseCommand;
import com.example.movie_nights_client.web.component.Movie;
import com.example.movie_nights_client.web.component.MovieList;
import com.example.movie_nights_client.web.component.MovieSearchBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Route(value = "search", layout = MainLayout.class)
public class MovieSearchPage extends VerticalLayout {

    private MovieList movies;

    public MovieSearchPage() {
        this.movies = new MovieList();

        setAlignItems(Alignment.CENTER);

        var searchBar = new MovieSearchBar(this);

        add(searchBar);
        add(movies);
    }

    public void searchForMovies(String title, String type, Double year) {
        movies.removeAll();

        String url = "http://localhost:8080/api/movie/many";

        var uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("page", 1)
                .queryParam("title", title)
                .queryParam("type", type);
        if (year != null) uri.queryParam("year", Integer.parseInt(year.toString()));

        uri.build();

        WebClient.create()
                .get()
                .uri(uri.toUriString())
                .retrieve()
                .bodyToFlux(RestMovieResponseCommand.class)
                .subscribe(movie -> getUI().ifPresent(ui -> ui.access(() -> movies.add(new Movie(movie)))));
    }
}

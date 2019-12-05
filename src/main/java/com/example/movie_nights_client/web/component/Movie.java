package com.example.movie_nights_client.web.component;

import com.example.movie_nights_client.command.RestMovieResponseCommand;
import com.example.movie_nights_client.web.page.IndexPage;
import com.example.movie_nights_client.web.page.SingleMoviePage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class Movie extends Div {

    public Movie() {
        setWidth("100%");
    }

    public Movie(RestMovieResponseCommand movieResponseCommand) {
        add(new H2(new RouterLink(movieResponseCommand.getTitle() + ", ("
                + movieResponseCommand.getYear() + ")", SingleMoviePage.class, movieResponseCommand.getImdbID())));

        var details = new HorizontalLayout();
        details.setWidth("100%");
        details.add(new Span(movieResponseCommand.getRuntime()));
        details.add(new Span(" | "));
        details.add(new Span(movieResponseCommand.getGenre()));
        details.add(new Span(" | "));
        details.add(new Span(movieResponseCommand.getYear()));
        details.add(new Span(" | "));
        details.add(new Span(movieResponseCommand.getCountry()));
        add(details);
    }
}

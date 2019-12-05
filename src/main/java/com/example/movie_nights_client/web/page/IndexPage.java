package com.example.movie_nights_client.web.page;

import com.example.movie_nights_client.MainLayout;
import com.example.movie_nights_client.command.RestMovieResponseCommand;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.web.util.UriComponentsBuilder;


import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "", layout = MainLayout.class)
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Vaadin n shit")
public class IndexPage extends VerticalLayout {

    private String username;

    private VerticalLayout movies = new VerticalLayout();

    public IndexPage() {

        addClassName("main-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 header = new H1("Welcome To Movie Nights!");

        add(header);

    }
}

package com.example.movie_nights_client;

import com.example.movie_nights_client.command.MovieResponseCommand;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;


import org.springframework.web.reactive.function.client.WebClient;


@Route("")
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Vaadin n shit")
@CssImport("./my-styles/style.css")
@Push
public class IndexPage extends VerticalLayout {

    private String username;

    private VerticalLayout movies = new VerticalLayout();

    public IndexPage() {

        addClassName("main-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 header = new H1("Welcome To Movie Nights!");

        add(header);
//        add(movies);


        String url = "http://localhost:8080/api/movie/many";

        var uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("page", 1)
                .queryParam("title", "Godfather");

        uri.build();

        WebClient.create()
                .get()
                .uri(uri.toUriString())
                .retrieve()
                .bodyToFlux(MovieResponseCommand.class)
                .subscribe(movie -> {
                    getUI().ifPresent(ui -> {
                        ui.access(() -> {
                            movies.add(new Paragraph(movie.getActors()));
                        });
                    });
                });

    }
}

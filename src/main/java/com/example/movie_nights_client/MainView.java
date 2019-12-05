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


@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Vaadin n shit")
@CssImport("./my-styles/style.css")
@Push
public class MainView extends VerticalLayout {

    private final UnicastProcessor<ChatMessage> publisher;
    private final Flux<ChatMessage> messages;
    private String username;

    private VerticalLayout movies = new VerticalLayout();

    public MainView(UnicastProcessor<ChatMessage> publisher, Flux<ChatMessage> messages) {

        this.publisher = publisher;
        this.messages = messages;
        addClassName("main-view");
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 header = new H1("Movie Nights");
        header.getElement().getThemeList().add("dark");

        add(header);
        add(movies);


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

//
//        askUsername();
    }

//    private void askUsername() {
//        var layout = new HorizontalLayout();;
//        var usernameField = new TextField();
//        Button startButton = new Button("Start chat");
//
//        startButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        usernameField.addKeyDownListener(Key.ENTER, event -> {
//            username = usernameField.getValue();
//            remove(layout);
//            showChat();
//        });
//
//        usernameField.focus();
//
//        startButton.addClickListener(click -> {
//            username = usernameField.getValue();
//            remove(layout);
//            showChat();
//        });
//
//        layout.add(usernameField, startButton);
//
//        add(layout);
//    }
//
//    private void showChat() {
//        MessageList messageList = new MessageList();
//        expand(messageList);
//        add(messageList, createInputLayout());
//
//
//        messages.subscribe(message -> {
//            getUI().ifPresent(ui -> ui.access(() -> messageList.add(
//                    new Paragraph(message.getFrom() + ": " + message.getMessage())
//            )));
//        });
//    }
//
//    private Component createInputLayout() {
//        var layout = new HorizontalLayout();
//        layout.setWidth("100%");
//
//        var messageField = new TextField();
//        var sendButton = new Button("Send");
//
//        messageField.focus();
//
//        sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        messageField.addKeyDownListener(Key.ENTER, event -> {
//            publisher.onNext(ChatMessage.builder()
//                    .from(username)
//                    .time(LocalDateTime.now())
//                    .message(messageField.getValue())
//                    .build());
//            messageField.clear();
//        });
//
//        sendButton.addClickListener(click -> {
//            publisher.onNext(ChatMessage.builder()
//                    .from(username)
//                    .time(LocalDateTime.now())
//                    .message(messageField.getValue())
//                    .build());
//            messageField.clear();
//            messageField.focus();
//        });
//
//        layout.add(messageField);
//        layout.add(sendButton);
//        layout.expand(messageField);
//
//        return layout;
//    }
}

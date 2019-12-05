package com.example.movie_nights_client.web.page;

import com.example.movie_nights_client.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

@Route(value = "movie", layout = MainLayout.class)
public class SingleMoviePage extends VerticalLayout implements AfterNavigationObserver, HasUrlParameter<String> {

    private String id;

    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
        add(new H2("id: " + id));
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        this.id = s;
    }
}

package com.example.movie_nights_client;

import com.example.movie_nights_client.web.page.IndexPage;
import com.example.movie_nights_client.web.page.LoginPage;
import com.example.movie_nights_client.web.page.MovieSearchPage;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@CssImport("./my-styles/style.css")
@Push
public class MainLayout extends VerticalLayout implements RouterLayout {

    public MainLayout() {
        var navigation = new HorizontalLayout();
        navigation.setWidth("100%");

        var logo = new RouterLink("Movie Nights", IndexPage.class);
        var login = new RouterLink("Login", LoginPage.class);
        var search = new RouterLink("Search For Movies", MovieSearchPage.class);
        logo.setClassName("navigation-logo");
        login.setClassName("navigation-link");
        search.setClassName("navigation-link");

        var logoHolder = new HorizontalLayout(logo);

        navigation.add(logoHolder);
        navigation.add(login);
        navigation.add(search);

        navigation.expand(logoHolder);

        navigation.setClassName("navigation");

        add(navigation);
    }
}

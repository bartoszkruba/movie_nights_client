package com.example.movie_nights_client;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
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
        logo.setClassName("navigation-logo");
        login.setClassName("navigation-link");

        var logoHolder = new HorizontalLayout(logo);

        navigation.add(logoHolder);
        navigation.add(login);
//        navigation.add(new H5("Register"));

        navigation.expand(logoHolder);

        navigation.setClassName("navigation");

        add(navigation);
    }
}

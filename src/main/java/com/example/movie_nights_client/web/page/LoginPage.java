package com.example.movie_nights_client.web.page;

import com.example.movie_nights_client.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "login", layout = MainLayout.class)
public class LoginPage extends VerticalLayout {

    public LoginPage() {

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        setWidth("100%");

        var header = new H1("Login To Your Account");
        var loginField = new TextField();
        var passwordField = new PasswordField();
        var loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(new HorizontalLayout(new VerticalLayout(
                header,
                new HorizontalLayout(
                        new VerticalLayout(new H5("Username"), loginField, loginButton),
                        new VerticalLayout(new H5("Password"), passwordField))
        )));
    }
}

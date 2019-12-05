package com.example.movie_nights_client.web.component;

import com.example.movie_nights_client.web.page.MovieSearchPage;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.time.LocalDate;

public class MovieSearchBar extends VerticalLayout {

    private TextField titleField = new TextField();
    private Select<String> typeSelect = new Select<>();
    private NumberField yearField = new NumberField();

    public MovieSearchBar(MovieSearchPage movieSearchPage) {
        var form = new HorizontalLayout();

        var titleInput = new VerticalLayout();
        titleInput.add(new H5("Title"));
        titleInput.add(titleField);

        var typeInput = new VerticalLayout();
        typeInput.add(new H5("Type"));
        typeSelect.setItems("movie", "series", "episode");
        typeSelect.setEmptySelectionAllowed(false);
        typeSelect.setPlaceholder("type");
        typeSelect.setValue("movie");
        typeInput.add(typeSelect);

        var yearInput = new VerticalLayout();
        yearInput.add(new H5("Year"));
        yearField.setMin(1900);
        yearField.setMin(LocalDate.now().getYear());
        yearField.setStep(1);
        yearInput.add(yearField);

        var searchInput = new VerticalLayout();
        var searchButton = new Button("Search");

        searchButton.addClickListener(click -> {
            movieSearchPage.searchForMovies(titleField.getValue(), typeSelect.getValue(), yearField.getValue());
        });

        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchInput.add(searchButton);

        form.add(titleInput, typeInput, yearInput, searchInput);
        form.setAlignItems(Alignment.END);
        add(form);
    }
}

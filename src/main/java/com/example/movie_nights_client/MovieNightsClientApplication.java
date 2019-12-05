package com.example.movie_nights_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

@SpringBootApplication
public class MovieNightsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieNightsClientApplication.class, args);
    }
}

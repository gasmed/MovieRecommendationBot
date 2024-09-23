package com.movierecommendationbot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final WebClient webClient;

    private final String apiKey = "d717d4057137b8cd3af7edce46016e10"; // Ваш API-ключ TMDb

    public MovieService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
    }

    public Mono<String> findMoviesByPreferences(String genre, String actor, String releaseYear) {
        String query = buildQuery(genre, actor, releaseYear);

        return webClient.get()
                .uri("/discover/movie?api_key=" + apiKey + query)
                .retrieve()
                .bodyToMono(String.class);
    }

    private String buildQuery(String genre, String actor, String releaseYear) {
        StringBuilder query = new StringBuilder();
        if (genre != null) {
            query.append("&with_genres=").append(genre);
        }
        if (actor != null) {
            query.append("&with_cast=").append(actor);
        }
        if (releaseYear != null) {
            query.append("&primary_release_year=").append(releaseYear);
        }
        return query.toString();
    }

    public Mono<String> findRandomMovie() {
        return webClient.get()
                .uri("/movie/popular?api_key=" + apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }
}

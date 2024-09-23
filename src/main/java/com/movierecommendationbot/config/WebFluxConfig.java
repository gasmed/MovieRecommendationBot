package com.movierecommendationbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class WebFluxConfig {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route()
                .GET("/health", request -> ServerResponse.ok().bodyValue("Service is up and running"))
                .build();
    }
}

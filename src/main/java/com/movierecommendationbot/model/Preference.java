package com.movierecommendationbot.model;

import java.util.List;

public class Preference {

    private List<String> genres;
    private List<String> actors;
    private List<String> releaseYears;

    public Preference() {}

    public Preference(List<String> genres, List<String> actors, List<String> releaseYears) {
        this.genres = genres;
        this.actors = actors;
        this.releaseYears = releaseYears;
    }

    // Геттеры и сеттеры
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getReleaseYears() {
        return releaseYears;
    }

    public void setReleaseYears(List<String> releaseYears) {
        this.releaseYears = releaseYears;
    }
}

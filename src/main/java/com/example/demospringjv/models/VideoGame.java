package com.example.demospringjv.models;

import java.time.LocalDate;
import java.util.List;

public class VideoGame {

    long id;

    String name;

    List<Genre> genres;

    LocalDate release;

    String studioName;

    int price;

    List<Platform> platforms;

    public VideoGame(String name ,List<Genre> genres, LocalDate release, String studioName, int price, List<Platform> platforms) {
        this.name = name;
        this.genres = genres;
        this.release = release;
        this.studioName = studioName;
        this.price = price;
        this.platforms = platforms;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public LocalDate getRelease() {
        return release;
    }

    public String getStudioName() {
        return studioName;
    }

    public int getPrice() {
        return price;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
}

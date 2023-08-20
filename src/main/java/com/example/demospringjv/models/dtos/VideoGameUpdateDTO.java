package com.example.demospringjv.models.dtos;

import java.time.LocalDate;

public class VideoGameUpdateDTO {

    private String title;
    private Integer price;
    private LocalDate releaseDate;
    private String studioName;

    public VideoGameUpdateDTO(String title, Integer price, LocalDate releaseDate, String studioName) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.studioName = studioName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
}

package com.example.demospringjv.service;

import com.example.demospringjv.models.Platform;
import com.example.demospringjv.models.VideoGame;

import java.util.List;

public interface VideoGameService {

    VideoGame addVideoGame(VideoGame videoGame);  // Ajouter un jv

    void deleteVideoGame(long id);               // Supprimer un jv

    VideoGame getVideoGame(long id);             // Récupérer un jv

    List<VideoGame> getAllVideoGames(Integer minPrice, Integer maxPrice); // Récupérer tous les jv avec option de filtre sur le prix

    VideoGame updateVideoGame(VideoGame videoGame); // Modifier totalement un jv

    VideoGame updateVideoGamePrice(long id, int price); // Modifier le prix d'un jv

    VideoGame addPlatformToVideoGame(long id, Platform platform); // Ajouter une plateforme à un jv

}

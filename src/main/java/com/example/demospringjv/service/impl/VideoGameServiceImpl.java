package com.example.demospringjv.service.impl;

import com.example.demospringjv.models.Platform;
import com.example.demospringjv.models.VideoGame;
import com.example.demospringjv.service.VideoGameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoGameServiceImpl implements VideoGameService {

    private List<VideoGame> videoGames = new ArrayList<>();
    private long currentId = 0L;
    @Override
    public VideoGame addVideoGame(VideoGame videoGame) {
        currentId++;
        videoGame.setId(currentId);
        videoGames.add(videoGame);
        return videoGame;
    }

    @Override
    public void deleteVideoGame(long id) {
        videoGames.removeIf(vg -> vg.getId() == id);
    }

    @Override
    public VideoGame getVideoGame(long id) {
        return videoGames.stream().filter(vg -> vg.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<VideoGame> getAllVideoGames(Integer minPrice, Integer maxPrice) {
        return videoGames.stream()
                .filter(vg -> (minPrice == null || vg.getPrice() >= minPrice) && (maxPrice == null || vg.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }

//    La méthode filter prend en paramètre un prédicat (une fonction qui renvoie un booléen). Ce prédicat est utilisé pour décider si un élément doit être inclus ou exclu du flux résultant.
//
//    Pour chaque jeu vidéo (vg) dans le flux :
//
//    Si minPrice est null, cela signifie qu'il n'y a pas de prix minimum à considérer, donc la première partie de l'expression (minPrice == null || vg.getPrice() >= minPrice) renverra true.
//    Si minPrice n'est pas null, alors la condition vérifie si le prix du jeu est supérieur ou égal à minPrice avec vg.getPrice() >= minPrice.
//    De même pour maxPrice :
//
//    Si maxPrice est null, cela signifie qu'il n'y a pas de prix maximum à considérer, donc la première partie de l'expression (maxPrice == null || vg.getPrice() <= maxPrice) renverra true.
//    Si maxPrice n'est pas null, alors la condition vérifie si le prix du jeu est inférieur ou égal à maxPrice avec vg.getPrice() <= maxPrice.
//    La combinaison des deux vérifications avec un && signifie que les deux conditions doivent être vraies pour qu'un jeu soit inclus dans le résultat.

    @Override
    public VideoGame updateVideoGame(VideoGame videoGame) {
        videoGames.set((int) videoGame.getId(), videoGame);
        return videoGame;
    }

    @Override
    public VideoGame updateVideoGamePrice(long id, int price) {
        VideoGame vg = getVideoGame(id);
        if (vg != null) {
            vg.setPrice(price);
        }
        return vg;
    }

    @Override
    public VideoGame addPlatformToVideoGame(long id, Platform platform) {
        VideoGame vg = getVideoGame(id);
        if (vg != null) {
            vg.getPlatforms().add(platform);
        }
        return vg;
    }

}

package com.example.demospringjv.controller;


import com.example.demospringjv.models.Platform;
import com.example.demospringjv.models.VideoGame;
import com.example.demospringjv.models.dtos.VideoGameUpdateDTO;
import com.example.demospringjv.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videogames")
public class VideoGameController {


    private final VideoGameService videoGameService;

    @Autowired
    public VideoGameController( VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }

    @GetMapping
    public List<VideoGame> getAllVideoGames(@RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice) {
        return videoGameService.getAllVideoGames(minPrice, maxPrice);
    }

    @GetMapping("/{id:[0-9]+}")
    public VideoGame getVideoGameById(@PathVariable long id) {
        return videoGameService.getVideoGame(id);
    }

    @PostMapping
    public VideoGame createVideoGame(@RequestBody VideoGame videoGame) {
        return videoGameService.addVideoGame(videoGame);
    }

    @PatchMapping("/{id:[0-9]+}")
    public VideoGame patchVideoGame(@PathVariable int id, @RequestBody VideoGame updatedVideoGame) {
        VideoGame existingVideoGame = videoGameService.getVideoGame(id);

        // Vérifiez chaque champ de updatedVideoGame pour déterminer si une mise à jour est nécessaire.

        if (updatedVideoGame.getName() != null && !updatedVideoGame.getName().isEmpty()){
            existingVideoGame.setName(updatedVideoGame.getName());
        }
        if (updatedVideoGame.getPrice() != 0){
            existingVideoGame.setPrice(updatedVideoGame.getPrice());
        }
        if (updatedVideoGame.getRelease() != null){
            existingVideoGame.setRelease(updatedVideoGame.getRelease());
        }
        if (updatedVideoGame.getStudioName() != null && !updatedVideoGame.getStudioName().isEmpty()){
            existingVideoGame.setStudioName(updatedVideoGame.getStudioName());
        }

        return videoGameService.updateVideoGame(existingVideoGame);
    }

    @PatchMapping("/{id:[0-9]+}/price")
    public VideoGame updateVideoGamePrice(@PathVariable long id, @RequestBody int price) {
        return videoGameService.updateVideoGamePrice(id, price);
    }

    @PatchMapping("/{id:[0-9]+}/platforms")
    public VideoGame addPlatformToVideoGame(@PathVariable long id, @RequestBody Platform platform) {
        return videoGameService.addPlatformToVideoGame(id, platform);
    }

    @DeleteMapping("/{id:[0-9]+}/delete")
    public void deleteVideoGame(@PathVariable long id) {
        videoGameService.deleteVideoGame(id);
    }

}

package com.soluinoon.hasearch.controller;

import com.soluinoon.hasearch.service.ChampionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

@Controller
public class ChampionController {
    private final ChampionService championService;
    private String championPath = "/Users/jihong-kim/ha-search/src/main/resources/dragontail-13.6.1/13.6.1/img/champion/";

    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping("/champions/{name}")
    @ResponseBody
    public ResponseEntity<byte []> getChampion(@PathVariable String name) throws IOException {
        Path imagePath = Paths.get(championPath + name + ".png");
        byte[] imageBytes = readAllBytes(imagePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}

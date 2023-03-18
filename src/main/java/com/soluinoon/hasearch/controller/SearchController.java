package com.soluinoon.hasearch.controller;

import com.soluinoon.hasearch.dto.search.SummonerInfoResponse;
import com.soluinoon.hasearch.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<SummonerInfoResponse> searchName(@RequestParam String name) {
        SummonerInfoResponse summonerInfo = searchService.getSummonerInfoByName(name);
        if (summonerInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(summonerInfo, HttpStatus.OK);
    }
}

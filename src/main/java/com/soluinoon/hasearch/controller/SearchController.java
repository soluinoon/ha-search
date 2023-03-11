package com.soluinoon.hasearch.controller;

import com.soluinoon.hasearch.dto.search.SummonerInfoResponse;
import com.soluinoon.hasearch.dto.search.SummonerNameRequest;
import com.soluinoon.hasearch.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public String searchName(@RequestBody SummonerNameRequest request, RedirectAttributes redirectAttributes) {
        SummonerInfoResponse summonerInfo = searchService.getSummonerInfoByName(request.getName());
        redirectAttributes.addAttribute("summonerInfo", summonerInfo);
        return "redirect:/info";
    }
}

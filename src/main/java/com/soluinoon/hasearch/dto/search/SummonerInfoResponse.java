package com.soluinoon.hasearch.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SummonerInfoResponse {
    String name;
    int profileIconId;
    long summonerLevel;
    List<String> matches;

    public SummonerInfoResponse(SummonerDto summonerDto, List<String> matches) {
        this.name = summonerDto.getName();
        this.profileIconId = summonerDto.getProfileIconId();
        this.summonerLevel = summonerDto.getSummonerLevel();
        this.matches = matches;
    }
}

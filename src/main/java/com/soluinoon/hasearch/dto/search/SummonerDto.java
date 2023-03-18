package com.soluinoon.hasearch.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SummonerDto {
    String accountId;
    int profileIconId;
    long revisionDate;
    String name;
    String id;
    String puuid;
    long summonerLevel;
}

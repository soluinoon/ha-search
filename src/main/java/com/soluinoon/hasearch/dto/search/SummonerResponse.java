package com.soluinoon.hasearch.dto.search;

public class SummonerResponse {
    String id;
    String accountId;
    String puuid;
    String name;
    int profileIconId;
    long revisionDate;
    long summonerLevel;

    public SummonerResponse(String id, String accountId, String puuid, String name, int profileIconId, long revisionDate, long summonerLevel) {
        this.id = id;
        this.accountId = accountId;
        this.puuid = puuid;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
    }
}

package com.soluinoon.hasearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soluinoon.hasearch.dto.search.SummonerDto;
import com.soluinoon.hasearch.dto.search.SummonerInfoResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Value("${external.api.key}")
    private String key;
    private ObjectMapper objectMapper = new ObjectMapper();
    private CloseableHttpClient client = HttpClients.createDefault();

    public SummonerInfoResponse getSummonerInfoByName(String name) {
        SummonerDto summoner = getSummonerByName(name);
        List<String> matches = getAramMatches(summoner.getPuuid());
        return new SummonerInfoResponse(summoner, matches);
    }

    private SummonerDto getSummonerByName(String name) {
        try {
            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/vezimil";
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("api_key", key).build(false);
            HttpGet request = new HttpGet(uri.toUri());
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IllegalArgumentException("실패");
            }

            HttpEntity entity = response.getEntity();

            return objectMapper.readValue(entity.getContent(), SummonerDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> getAramMatches(String puuid) {
        try {
            UriComponents uri = UriComponentsBuilder.fromUriString("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid")
                    .path("/{puuid}").path("/ids").query("start={queryValue1}").query("count={queryValue2}").query("api_key={queryValue3}")
                    .buildAndExpand(puuid, "0", "20", key);

            HttpGet request = new HttpGet(uri.toUri());
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IllegalArgumentException("실패");
            }

            HttpEntity entity = response.getEntity();
            InputStream stream = entity.getContent();

            BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            String temp;
            List<String> matches = new ArrayList<>();
            while ((temp = br.readLine()) != null) {
                matches.add(temp);
            }
            return matches;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.soluinoon.hasearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soluinoon.hasearch.dto.search.SummonerResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchService {
    @Value("${external.api.key}")
    private String key;
    private ObjectMapper objectMapper = new ObjectMapper();

    public SummonerResponse getSummonerByName(String name) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();

            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/vezimil";
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("api_key", key).build(false);

            System.out.println("uri.toString() = " + uri.toString());

            HttpGet request = new HttpGet(uri.toUri());
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new IllegalArgumentException("실패");
            }

            HttpEntity entity = response.getEntity();
            return objectMapper.readValue(entity.getContent(), SummonerResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.soluinoon.hasearch.service;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
//    @Value("${external.api.key}")
//    private String key;
//    private ObjectMapper objectMapper = new ObjectMapper();
//    private CloseableHttpClient client = HttpClients.createDefault();
//
//    public SummonerInfoResponse getSummonerInfoByName(String name) {
//        SummonerDto summoner = getSummonerByName(name);
//        List<String> matches = getAramMatches(summoner.getPuuid());
//        return new SummonerInfoResponse(summoner, matches);
//    }
//
//    private SummonerDto getSummonerByName(String name) {
//        try {
////            다른방식
////            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name";
////            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
////                    .path("/{name}").query("api_key={key}")
////                    .buildAndExpand(name, key);
//
//            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{name}?api_key={key}";
//
//            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
//                    .buildAndExpand(name, key);
//            HttpGet request = new HttpGet(uri.toUri());
//            HttpResponse response = client.execute(request);
//
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new IllegalArgumentException("실패");
//            }
//
//            HttpEntity entity = response.getEntity();
//
//            return objectMapper.readValue(entity.getContent(), SummonerDto.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private List<String> getAramMatches(String puuid) {
//        try {
//            UriComponents uri = UriComponentsBuilder.fromUriString("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid")
//                    .path("/{puuid}").path("/ids").query("start={queryValue1}").query("count={queryValue2}").query("api_key={queryValue3}")
//                    .buildAndExpand(puuid, "0", "20", key);
//
//            HttpGet request = new HttpGet(uri.toUri());
//            HttpResponse response = client.execute(request);
//
//            if (response.getStatusLine().getStatusCode() != 200) {
//                throw new IllegalArgumentException("실패");
//            }
//
//            HttpEntity entity = response.getEntity();
//            InputStream stream = entity.getContent();
//            BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
//            String data = br.readLine();
//            data = data.replaceAll("[\"\\[\\]]", "");
//            List<String> dataList = Arrays.asList(data.split(","));
//
//            return dataList;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}

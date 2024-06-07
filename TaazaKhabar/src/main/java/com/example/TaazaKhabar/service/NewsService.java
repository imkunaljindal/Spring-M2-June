package com.example.TaazaKhabar.service;

import com.example.TaazaKhabar.response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    public NewsResponse getNews(String country, String apiKey) {
        String url = prepareUrl(country,apiKey);
        return restTemplate.getForObject(url,NewsResponse.class);
    }

    private String prepareUrl(String country,
                              String apiKey) {
        return "https://newsapi.org/v2/top-headlines?country="
                + country + "&apiKey=" + apiKey;
    }

    public Object getPatient() {
        String url = "http://localhost:8080/patient/get?id=1";
        return restTemplate.getForObject(url,Object.class);
    }
}

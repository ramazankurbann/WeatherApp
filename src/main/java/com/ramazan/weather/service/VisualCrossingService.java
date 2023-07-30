package com.ramazan.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class VisualCrossingService
{
    private final RestTemplate restTemplate;

    @Value("${spring.data.visualCrossing.url}")
    String url;
    @Value("${spring.data.visualCrossing.key}")
    String key;

    public String GetWeatherJSON(String city){
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(city);
        sb.append(key);
        return restTemplate.getForObject(sb.toString(), String.class);
    }
}

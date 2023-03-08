package com.ramazan.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class VisualCrossingApi
{
    private final RestTemplate restTemplate;

    String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    String key = "?key=N5PY9Y4DPDRC3CC8H755RZ3YW";

    @GetMapping
    public String GetWeatherJSON(String city){
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(city);
        sb.append(key);
        return restTemplate.getForObject(sb.toString(), String.class);
    }
}

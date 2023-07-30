package com.ramazan.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramazan.weather.entity.CityWeather;
import com.ramazan.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dailyweather")
@RequiredArgsConstructor
public class CityWeatherApi
{
    private final WeatherService weatherService;

    @CrossOrigin
    @GetMapping("/getCity/{city}")
    public ResponseEntity<CityWeather> GetDailyWeather(@PathVariable String city){
        return ResponseEntity.ok(weatherService.GetCityWeather(city));
    }
}

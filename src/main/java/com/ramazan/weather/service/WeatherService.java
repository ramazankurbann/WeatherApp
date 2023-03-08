package com.ramazan.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramazan.weather.controller.VisualCrossingApi;
import com.ramazan.weather.entity.CityWeather;
import com.ramazan.weather.repository.CityWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService
{
    private final CityWeatherRepository cityWeatherRepository;
    private final VisualCrossingApi visualCrossingApi;

    public Optional<CityWeather> GetCityWeather(String id){
        return cityWeatherRepository.findById(id);
    }

    public CityWeather CityWeatherProcess(String city){
        CityWeather cityWeather = null;

        try{
            String cityWeatherJSON = visualCrossingApi.GetWeatherJSON(city);
            ObjectMapper objectMapper = new ObjectMapper();
            cityWeather = objectMapper.readValue(cityWeatherJSON, CityWeather.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(cityWeather != null){
            cityWeatherRepository.save(cityWeather);
        }

        return cityWeather;
    }
}

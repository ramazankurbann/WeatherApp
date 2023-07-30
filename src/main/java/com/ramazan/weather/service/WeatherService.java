package com.ramazan.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramazan.weather.entity.CityWeather;
import com.ramazan.weather.repository.CityWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService
{
    private final CityWeatherRepository cityWeatherRepository;
    private final VisualCrossingService visualCrossingService;

    public CityWeather GetCityWeather(String id){
        Optional<CityWeather> cityWeatherOptional = cityWeatherRepository.findById(id);

        return cityWeatherOptional.orElseGet(() -> this.CityWeatherProcess(id));
    }

    public CityWeather CityWeatherProcess(String city){
        CityWeather cityWeather = null;

        try{
            String cityWeatherJSON = visualCrossingService.GetWeatherJSON(city);
            ObjectMapper objectMapper = new ObjectMapper();
            cityWeather = objectMapper.readValue(cityWeatherJSON, CityWeather.class);
            cityWeatherRepository.save(cityWeather);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return cityWeather;
    }
}

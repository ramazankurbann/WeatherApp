package com.ramazan.weather.repository;

import com.ramazan.weather.entity.CityWeather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityWeatherRepository extends MongoRepository<CityWeather, String>
{
}

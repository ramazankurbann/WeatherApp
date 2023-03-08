package com.ramazan.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ramazan.weather.entity.field.DailyWeather;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CityWeather
{
    @Id
    private String address;
    private DailyWeather[] days;
}

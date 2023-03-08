package com.ramazan.weather.entity.field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class DailyWeather
{
    private String datetime;
    private Float tempmax;
    private Float tempmin;
    private Float temp;
    private String icon;
}

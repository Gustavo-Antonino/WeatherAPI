package com.gustavo.antonino.weatherAPI.WeatherAPI.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class WeatherResponse {

    @JsonProperty("name")
    private String city;

    @JsonProperty("main")
    private Map<String, Object> main;

    @JsonProperty("weather")
    private WeatherDescription[] weather;

    @JsonProperty("wind")
    private Map<String, Object> wind;

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return (double) main.get("temp");
    }

    public int getHumidity() {
        return (int) main.get("humidity");
    }

    public String getDescription() {
        return weather.length > 0 ? weather[0].description : "N/A";
    }

    public double getWindSpeed() {
        return (double) wind.get("speed");
    }

    private static class WeatherDescription {
        @JsonProperty("description")
        private String description;
    }
}

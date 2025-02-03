package com.gustavo.antonino.weatherAPI.WeatherAPI.service;


import com.gustavo.antonino.weatherAPI.WeatherAPI.entities.Weather;
import com.gustavo.antonino.weatherAPI.WeatherAPI.entities.WeatherResponse;
import com.gustavo.antonino.weatherAPI.WeatherAPI.repositories.WeatherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;
    private static final String HG_WEATHER_URL = "https://api.hgbrasil.com/weather?city_name=";

    public WeatherService(WeatherRepository weatherRepository) {
        this.restTemplate = new RestTemplate();
        this.weatherRepository = weatherRepository;
    }

    public Weather getCurrentWeather(String city) {
        String url = HG_WEATHER_URL + city;
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response != null) {
            Weather weather = new Weather(
                    response.getCity(),
                    response.getTemperature(),
                    response.getHumidity(),
                    response.getDescription(),
                    response.getWindSpeed()
            );

            weatherRepository.save(weather);
            return weather;
        }
        return null;
    }

    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    public Weather getWeatherById(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    public List<Weather> getWeatherHistory(String city) {
        return weatherRepository.findByCity(city);
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Weather updateWeather(Long id, Weather updatedWeather) {
        Optional<Weather> existingWeather = weatherRepository.findById(id);
        if (existingWeather.isPresent()) {
            Weather weather = existingWeather.get();
            weather.setCity(updatedWeather.getCity());
            weather.setTemperature(updatedWeather.getTemperature());
            weather.setHumidity(updatedWeather.getHumidity());
            weather.setDescription(updatedWeather.getDescription());
            weather.setWindSpeed(updatedWeather.getWindSpeed());
            return weatherRepository.save(weather);
        }
        return null;
    }

    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }
}

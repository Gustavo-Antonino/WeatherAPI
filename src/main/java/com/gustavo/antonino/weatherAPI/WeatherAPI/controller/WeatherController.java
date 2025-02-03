package com.gustavo.antonino.weatherAPI.WeatherAPI.controller;

import com.gustavo.antonino.weatherAPI.WeatherAPI.entities.Weather;
import com.gustavo.antonino.weatherAPI.WeatherAPI.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Obtém a previsão atual
    @GetMapping("/current")
    public Weather getCurrentWeather(@RequestParam String city) {
        return weatherService.getCurrentWeather(city);
    }

    // Obtém a previsão para os próximos dias (simulação)
    @GetMapping("/forecast")
    public String getForecast(@RequestParam String city) {
        return "Previsão futura para " + city + " ainda não implementada.";
    }

    // Salva um registro de previsão no banco
    @PostMapping("/save")
    public Weather saveWeather(@RequestBody Weather weather) {
        return weatherService.saveWeather(weather);
    }

    // Lista todas as previsões salvas
    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherService.getAllWeather();
    }

    // Busca uma previsão salva pelo ID
    @GetMapping("/{id}")
    public Weather getWeatherById(@PathVariable Long id) {
        return weatherService.getWeatherById(id);
    }

    // Atualiza um registro salvo
    @PutMapping("/{id}")
    public Weather updateWeather(@PathVariable Long id, @RequestBody Weather updatedWeather) {
        return weatherService.updateWeather(id, updatedWeather);
    }

    // Remove um registro salvo
    @DeleteMapping("/{id}")
    public void deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeather(id);
    }

    // Obtém previsões salvas de uma cidade específica
    @GetMapping("/history")
    public List<Weather> getWeatherHistory(@RequestParam String city) {
        return weatherService.getWeatherHistory(city);
    }
}
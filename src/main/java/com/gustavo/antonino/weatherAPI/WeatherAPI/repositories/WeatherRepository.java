package com.gustavo.antonino.weatherAPI.WeatherAPI.repositories;

import com.gustavo.antonino.weatherAPI.WeatherAPI.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}

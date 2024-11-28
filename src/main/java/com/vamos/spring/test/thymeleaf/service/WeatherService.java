package com.vamos.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.spring.test.thymeleaf.domain.Weather;
import com.vamos.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather>  getWeahtherList() {
			
		List<Weather> weather =  weatherRepository.selectWeatherHistory();
		return weather;
	}
	
	public int addWeather(
			LocalDate date
			,String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		return count;
	}
	
	
}
package br.com.ariki.music.suggestion.by.weather.usecase.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.WeatherByCityGateway;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchWeatherByCityService {

	
	private WeatherByCityGateway gateway;

	public SearchWeatherByCityService(WeatherByCityGateway gateway) {
		this.gateway = gateway;
	}
	
	@HystrixCommand(fallbackMethod = "executeRecover")
	public Temperature execute(String cityName) {
		log.debug("Init execute");
		return gateway.getWeatherByCity(cityName);
	}
	
	public Temperature executeRecover(String cityName, Throwable ex) {
		log.debug("Init executeRecover");
		log.error("Hystrix called executeRecover for param {}", ex.getMessage());
		return null;
	}
}

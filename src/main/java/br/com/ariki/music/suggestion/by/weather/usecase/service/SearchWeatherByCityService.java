package br.com.ariki.music.suggestion.by.weather.usecase.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ariki.music.suggestion.by.weather.domain.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.gateway.OpenWeatherMapGateway;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchWeatherByCityService {

	
	private OpenWeatherMapGateway gateway;

	public SearchWeatherByCityService(OpenWeatherMapGateway gateway) {
		this.gateway = gateway;
	}
	
	@HystrixCommand(fallbackMethod = "executeRecover")
	public Temperature execute(String cityName) {
		return gateway.getWeatherByCity(cityName);
	}
	
	public Temperature executeRecover(String cityName, Throwable ex) {
		log.error("Hystrix called executeRecover for param {}", ex.getMessage());
		return null;
	}
}

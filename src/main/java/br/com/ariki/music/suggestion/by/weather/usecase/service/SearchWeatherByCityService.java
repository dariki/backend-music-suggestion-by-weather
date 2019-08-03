package br.com.ariki.music.suggestion.by.weather.usecase.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.SearchWeatherByCityGateway;

@Service
public class SearchWeatherByCityService {

	
	private SearchWeatherByCityGateway gateway;

	public SearchWeatherByCityService(SearchWeatherByCityGateway gateway) {
		this.gateway = gateway;
	}
	
	@HystrixCommand(fallbackMethod = "executeRecover")
	public Temperature execute(String cityName) {
		return gateway.getWeatherByCity(cityName);
	}
	
	public Temperature executeRecover(String cityName) {
		return Temperature.builder()
				.temperature(-99999D)
				.build();
	}
}

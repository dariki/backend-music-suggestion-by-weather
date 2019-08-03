package br.com.ariki.music.suggestion.by.weather.usecase.gateway;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;

public interface SearchWeatherByCityGateway {
	
	Temperature getWeatherByCity(String cityName);

}

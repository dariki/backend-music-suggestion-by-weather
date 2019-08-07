package br.com.ariki.music.suggestion.by.weather.gateway;

import br.com.ariki.music.suggestion.by.weather.domain.entity.Temperature;

public interface WeatherByCityGateway {
	
	Temperature getWeatherByCity(String cityName);

}

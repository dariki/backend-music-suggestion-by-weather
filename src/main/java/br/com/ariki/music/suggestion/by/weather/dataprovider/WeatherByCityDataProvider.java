package br.com.ariki.music.suggestion.by.weather.dataprovider;

import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.FeignOpenWeatherMapAPI;
import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.mapper.OpenWeatherMapResponseToTemperature;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.WeatherByCityGateway;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherByCityDataProvider implements WeatherByCityGateway {
	
	private FeignOpenWeatherMapAPI client;

	public WeatherByCityDataProvider(FeignOpenWeatherMapAPI client) {
		this.client = client;
	}
	
	public Temperature getWeatherByCity(String cityName) {
		log.debug("Init getWeatherByCity");
		return OpenWeatherMapResponseToTemperature.to(client.getWeather(cityName));
	}

}
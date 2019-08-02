package br.com.ariki.music.suggestion.by.weather.dataprovider;

import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.FeignOpenWeatherMapAPI;
import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.mapper.OpenWeatherMapResponseToTemperature;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;

@Component
public class SearchWeatherByCityDataProvider {
	
	private FeignOpenWeatherMapAPI client;

	public SearchWeatherByCityDataProvider(FeignOpenWeatherMapAPI client) {
		this.client = client;
	}
	
	public Temperature getWeatherByCity(String cityName) {
		
		return OpenWeatherMapResponseToTemperature.to(client.getStores(cityName));
		
	}

}

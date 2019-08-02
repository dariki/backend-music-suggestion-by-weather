package br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.mapper;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.response.OpenWeatherMapResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;

public class OpenWeatherMapResponseToTemperature {
	
	private OpenWeatherMapResponseToTemperature() { }
	
	public static Temperature to(OpenWeatherMapResponse response) {
		return Temperature.builder()
				.temperature(response.getMain().getTemperature())
				.build();
	}

}

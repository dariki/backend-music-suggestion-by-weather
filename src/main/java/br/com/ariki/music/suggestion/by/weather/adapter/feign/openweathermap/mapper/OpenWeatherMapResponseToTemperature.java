package br.com.ariki.music.suggestion.by.weather.adapter.feign.openweathermap.mapper;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.response.OpenWeatherMapResponse;
import br.com.ariki.music.suggestion.by.weather.domain.entity.Temperature;

public class OpenWeatherMapResponseToTemperature {
	
	private OpenWeatherMapResponseToTemperature() { }
	
	public static Temperature to(OpenWeatherMapResponse response) {
		return Temperature.builder()
				.temperature(response.getMain().getTemperature())
				.build();
	}

}

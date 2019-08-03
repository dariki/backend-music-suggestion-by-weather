package br.com.ariki.music.suggestion.by.weather.entrypoint.controller.mapper;

import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.TemperatureResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;

public class TemperatureToTemperatureResponse {
	
	public static TemperatureResponse to(Temperature temperature) {
		return TemperatureResponse.builder()
				.temperature(temperature.getTemperature())
				.build();
	}

}

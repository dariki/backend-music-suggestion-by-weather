package br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TemperatureResponse {
	
	private Double temperature;

}

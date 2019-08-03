package br.com.ariki.music.suggestion.by.weather.entrypoint.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.mapper.TemperatureToTemperatureResponse;
import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.TemperatureResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SearchWeatherByCityService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/suggestion")
@Slf4j
public class SuggestionController {
	
	private SearchWeatherByCityService service;
	
	public SuggestionController(SearchWeatherByCityService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<TemperatureResponse> getSuggestion(@RequestParam(name = "q") String cityName ) {
		log.debug("Init getSuggestion");
		
		Optional<Temperature> optional = Optional.ofNullable(service.execute(cityName));
		
		return optional.map(temperature -> ResponseEntity.ok(TemperatureToTemperatureResponse.to(temperature)))
				.orElse(ResponseEntity.noContent().build());
	}

}

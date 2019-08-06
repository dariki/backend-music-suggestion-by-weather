package br.com.ariki.music.suggestion.by.weather.usecase.orchestrator;

import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.service.FindPlaylistService;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SearchWeatherByCityService;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SpotifyTokenService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SuggestionPlaylistOrchestrator {

	private SearchWeatherByCityService serviceWeather;
	private SpotifyTokenService serviceSpotifyToken;
	private FindPlaylistService findService;

	public SuggestionPlaylistOrchestrator(SearchWeatherByCityService serviceWeather, SpotifyTokenService serviceSpotifyToken, FindPlaylistService findService) {
		this.serviceWeather = serviceWeather;
		this.serviceSpotifyToken = serviceSpotifyToken;
		this.findService= findService;
	}

	public Playlist execute(String cityName) {
		log.debug("init execute");
		Temperature temperature = serviceWeather.execute(cityName);
		String token = serviceSpotifyToken.execute();
		return findService.execute(temperature, token);
	}

}

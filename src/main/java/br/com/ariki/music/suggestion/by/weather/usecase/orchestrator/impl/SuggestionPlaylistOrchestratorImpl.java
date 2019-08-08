package br.com.ariki.music.suggestion.by.weather.usecase.orchestrator.impl;

import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.domain.entity.Playlist;
import br.com.ariki.music.suggestion.by.weather.domain.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.usecase.orchestrator.SuggestionPlaylistOrchestrator;
import br.com.ariki.music.suggestion.by.weather.usecase.service.FindPlaylistService;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SearchWeatherByCityService;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SearchWeatherByLatLonService;
import br.com.ariki.music.suggestion.by.weather.usecase.service.SpotifyTokenService;

@Component
public class SuggestionPlaylistOrchestratorImpl implements SuggestionPlaylistOrchestrator {

	private SearchWeatherByCityService serviceByCity;
	private SearchWeatherByLatLonService serviceByLatLon;
	private SpotifyTokenService serviceSpotifyToken;
	private FindPlaylistService findService;

	public SuggestionPlaylistOrchestratorImpl(
			SearchWeatherByCityService serviceByCity, 
			SpotifyTokenService serviceSpotifyToken, 
			FindPlaylistService findService, 
			SearchWeatherByLatLonService serviceByLatLon) {
		this.serviceByCity = serviceByCity;
		this.serviceSpotifyToken = serviceSpotifyToken;
		this.findService= findService;
		this.serviceByLatLon = serviceByLatLon;
	}

	public Playlist executeByCityName(String cityName) {
		Temperature temperature = serviceByCity.execute(cityName);
		String token = serviceSpotifyToken.execute();
		return findService.execute(temperature, token);
	}

	@Override
	public Playlist executeByLatLon(String lat, String lon) {
		Temperature temperature = serviceByLatLon.execute(lat, lon);
		String token = serviceSpotifyToken.execute();
		return findService.execute(temperature, token);
	}

}

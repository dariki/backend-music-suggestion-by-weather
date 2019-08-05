package br.com.ariki.music.suggestion.by.weather.usecase.gateway;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.SpotifyToken;

public interface SpotifyAccountGateway {
	
	SpotifyToken getToken();
	
}

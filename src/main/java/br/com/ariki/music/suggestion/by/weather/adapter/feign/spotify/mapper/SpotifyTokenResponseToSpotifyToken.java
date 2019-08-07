package br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.mapper;

import br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.response.SpotifyTokenResponse;
import br.com.ariki.music.suggestion.by.weather.domain.entity.SpotifyToken;

public class SpotifyTokenResponseToSpotifyToken {
	
	private SpotifyTokenResponseToSpotifyToken() { }
	
	public static SpotifyToken to(SpotifyTokenResponse response) {
		return SpotifyToken.builder()
				.accessToken(response.getAccessToken())
				.build();
	}

}

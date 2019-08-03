package br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.mapper;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.response.SpotifyTokenResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.SpotifyToken;

public class SpotifyTokenResponseToSpotifyToken {
	
	private SpotifyTokenResponseToSpotifyToken() { }
	
	public static SpotifyToken to(SpotifyTokenResponse response) {
		return SpotifyToken.builder()
				.accessToken(response.getAccessToken())
				.build();
	}

}

package br.com.ariki.music.suggestion.by.weather.dataprovider;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.FeignSpotifyAccountAPI;
import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.mapper.SpotifyTokenResponseToSpotifyToken;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.SpotifyToken;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.SpotifyAccountGateway;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpotifyAccountDataProvider implements SpotifyAccountGateway {
	
	private FeignSpotifyAccountAPI client;
	
	public SpotifyAccountDataProvider(FeignSpotifyAccountAPI client) {
		this.client = client;
	}
	
	public SpotifyToken getToken() {
		log.debug("Init getToken");
		String token = "Basic 152af389eafc4796b74852d91bbc64a4:d343a11996d04a229fecf598e996b3a7";
		MultiValueMap<String, String> bodyRequestMap = new LinkedMultiValueMap<>();
		bodyRequestMap.add("grant_type", "client_credentials");
		return SpotifyTokenResponseToSpotifyToken.to(client.getToken(token, bodyRequestMap));
	}

}

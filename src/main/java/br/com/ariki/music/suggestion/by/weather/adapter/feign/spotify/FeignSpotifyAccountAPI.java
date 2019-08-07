package br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.response.SpotifyTokenResponse;
import feign.Headers;


@FeignClient(name = "${spotify.feign.account.name}", url = "${spotify.feign.account.url}")
public interface FeignSpotifyAccountAPI {

	@RequestMapping(method = RequestMethod.POST, value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@Headers("Content-Type: application/x-www-form-urlencoded")
	SpotifyTokenResponse getToken(
			@RequestHeader(name = "Authorization") String token,
			@RequestBody MultiValueMap<String, String> bodyRequestMap);
}

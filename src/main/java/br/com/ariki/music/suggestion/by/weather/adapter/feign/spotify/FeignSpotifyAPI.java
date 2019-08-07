package br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.response.PlaylistResponse;

@FeignClient(name = "${spotify.feign.api.name}", url = "${spotify.feign.api.url}")
public interface FeignSpotifyAPI {

	@RequestMapping(method = RequestMethod.GET, value = "/playlists/{playlist_id}")
	PlaylistResponse getPlaylist(
			@RequestHeader(name = "Authorization") String token,
			@PathVariable("playlist_id") String playlistId);
}

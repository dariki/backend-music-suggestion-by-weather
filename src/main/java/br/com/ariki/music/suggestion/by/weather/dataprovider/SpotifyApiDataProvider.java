package br.com.ariki.music.suggestion.by.weather.dataprovider;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.FeignSpotifyAPI;
import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.mapper.TrackToTrackInfo;
import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.response.PlaylistResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.SpotifyAPIGateway;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpotifyApiDataProvider implements SpotifyAPIGateway {
	
	private FeignSpotifyAPI client;
	
	public SpotifyApiDataProvider(FeignSpotifyAPI client) {
		this.client = client;
	}
	
	public Playlist getPlaylist() {
		log.debug("Init getToken");
		String token = "Bearer BQDoYoU0Lzft-SBAtI7U12KQQ27vb1f5UapcVBJQ7BXPEsrEQMCPJHN8X-dwxN9NMZSS1CrHVGLk0bbqg4E";
		PlaylistResponse response = client.getPlaylist(token, "37i9dQZF1DX8FwnYE6PRvL");
		return Playlist.builder()
				.trackInfo(response.getTracks().getItems().stream()
						.map(item -> TrackToTrackInfo.to(item.getTrack()))
						.collect(Collectors.toList()))
			.build();
	}

}

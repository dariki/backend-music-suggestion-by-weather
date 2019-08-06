package br.com.ariki.music.suggestion.by.weather.entrypoint.controller.mapper;

import java.util.stream.Collectors;

import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.PlaylistResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;

public class PlaylistToPlaylistResponse {
	
	public static PlaylistResponse to(Playlist playlist) {
		return PlaylistResponse.builder()
				.descricao(playlist.getDescription())
				.trackResponses(playlist.getTrackInfo().stream()
						.map(TrackInfoToTrackInfoResponse::to).collect(Collectors.toList()))
				.build();
	}

}

package br.com.ariki.music.suggestion.by.weather.entrypoint.controller.mapper;

import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.TrackInfoResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.TrackInfo;

public class TrackInfoToTrackInfoResponse {
	
	public static TrackInfoResponse to(TrackInfo trackInfo) {
		return TrackInfoResponse.builder()
				.artista(trackInfo.getArtistName())
				.musica(trackInfo.getMusicName())
				.build();
	}

}

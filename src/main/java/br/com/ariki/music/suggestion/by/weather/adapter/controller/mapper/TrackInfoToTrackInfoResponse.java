package br.com.ariki.music.suggestion.by.weather.adapter.controller.mapper;

import br.com.ariki.music.suggestion.by.weather.adapter.controller.response.TrackInfoResponse;
import br.com.ariki.music.suggestion.by.weather.domain.entity.TrackInfo;

public class TrackInfoToTrackInfoResponse {
	
	public static TrackInfoResponse to(TrackInfo trackInfo) {
		return TrackInfoResponse.builder()
				.artista(trackInfo.getArtistName())
				.musica(trackInfo.getMusicName())
				.build();
	}

}

package br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.mapper;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.response.Track;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.TrackInfo;

public class TrackToTrackInfo {

	private TrackToTrackInfo() { }
	
	public static TrackInfo to(Track response) {
		return TrackInfo.builder()
				.artistName(response.getArtists().get(0).getName())
				.musicName(response.getName())
				.build();
	}
}

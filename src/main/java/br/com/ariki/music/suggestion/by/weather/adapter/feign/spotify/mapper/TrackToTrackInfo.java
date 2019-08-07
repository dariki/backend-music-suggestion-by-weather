package br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.mapper;

import br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.response.Track;
import br.com.ariki.music.suggestion.by.weather.domain.entity.TrackInfo;

public class TrackToTrackInfo {

	private TrackToTrackInfo() { }
	
	public static TrackInfo to(Track response) {
		return TrackInfo.builder()
				.artistName(response.getArtists().get(0).getName())
				.musicName(response.getName())
				.build();
	}
}

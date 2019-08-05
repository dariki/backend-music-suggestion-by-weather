package br.com.ariki.music.suggestion.by.weather.usecase.entity;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Playlist {
	
	private List<TrackInfo> trackInfo;

}

package br.com.ariki.music.suggestion.by.weather.adapter.feign.spotify.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Items {
	
	private Track track;

}

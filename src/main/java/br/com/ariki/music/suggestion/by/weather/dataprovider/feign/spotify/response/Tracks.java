package br.com.ariki.music.suggestion.by.weather.dataprovider.feign.spotify.response;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Tracks {

	private List<Items> items;
}

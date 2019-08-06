package br.com.ariki.music.suggestion.by.weather.usecase.gateway;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.MusicStyle;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;

public interface SpotifyAPIGateway {
	
	Playlist getPlaylist(MusicStyle musicStyle, String token);
}

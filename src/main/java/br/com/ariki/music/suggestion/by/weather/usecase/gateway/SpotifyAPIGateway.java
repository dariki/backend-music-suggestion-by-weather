package br.com.ariki.music.suggestion.by.weather.usecase.gateway;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;

public interface SpotifyAPIGateway {
	
	Playlist getPlaylist();
}

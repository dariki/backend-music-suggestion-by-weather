package br.com.ariki.music.suggestion.by.weather.entrypoint.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.mapper.PlaylistToPlaylistResponse;
import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.PlaylistResponse;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Playlist;
import br.com.ariki.music.suggestion.by.weather.usecase.orchestrator.SuggestionPlaylistOrchestrator;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/suggestion")
@Slf4j
public class SuggestionController {
	
	private SuggestionPlaylistOrchestrator orchestrator;
	
	public SuggestionController(SuggestionPlaylistOrchestrator orchestrator) {
		this.orchestrator = orchestrator;
	}

	@GetMapping
	public ResponseEntity<PlaylistResponse> getSuggestion(@RequestParam(name = "q") String cityName ) {
		log.debug("Init getSuggestion");
		
		Optional<Playlist> optional = Optional.ofNullable(orchestrator.execute(cityName));
		
		return optional.map(playlist -> ResponseEntity.ok(PlaylistToPlaylistResponse.to(playlist)))
				.orElse(ResponseEntity.noContent().build());
	}

}

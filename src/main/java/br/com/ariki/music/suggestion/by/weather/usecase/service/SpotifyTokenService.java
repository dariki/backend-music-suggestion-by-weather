package br.com.ariki.music.suggestion.by.weather.usecase.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ariki.music.suggestion.by.weather.usecase.entity.SpotifyToken;
import br.com.ariki.music.suggestion.by.weather.usecase.gateway.SpotifyAccountGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpotifyTokenService {
	
	private SpotifyAccountGateway gateway;

	public SpotifyTokenService(SpotifyAccountGateway gateway) {
		this.gateway = gateway;
	}
	
	@HystrixCommand(fallbackMethod = "executeRecover")
	public String execute() {
		log.debug("Init execute");
		SpotifyToken token = gateway.getToken();
		return token.getAccessToken();
	}
	
	public String executeRecover() {
		log.debug("Init executeRecover");
		log.error("Hystrix called executeRecover because token error");
		return null;
	}

}

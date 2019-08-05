package br.com.ariki.music.suggestion.by.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.ariki.music.suggestion.by.weather.dataprovider.SpotifyApiDataProvider;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private SpotifyApiDataProvider dataprovider;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(dataprovider.getPlaylist());
	}
}

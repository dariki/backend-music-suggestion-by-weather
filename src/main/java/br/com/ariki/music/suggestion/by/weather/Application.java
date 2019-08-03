package br.com.ariki.music.suggestion.by.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.ariki.music.suggestion.by.weather.dataprovider.SearchWeatherByCityDataProvider;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	SearchWeatherByCityDataProvider dataprovider;
}

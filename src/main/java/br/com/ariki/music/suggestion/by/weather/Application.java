package br.com.ariki.music.suggestion.by.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.ariki.music.suggestion.by.weather.dataprovider.SearchWeatherByCityDataProvider;
import br.com.ariki.music.suggestion.by.weather.usecase.entity.Temperature;

@SpringBootApplication
@EnableFeignClients
public class Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	SearchWeatherByCityDataProvider dataprovider;
	
	@Override
	public void run(String... args) throws Exception {
		
		Temperature temperature = dataprovider.getWeatherByCity("New York");
		
		System.out.println(temperature);
		
	}
	
}

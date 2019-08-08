package br.com.ariki.music.suggestion.by.weather.gateway.dataprovider;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.domain.entity.Temperature;
import br.com.ariki.music.suggestion.by.weather.gateway.OpenWeatherMapGateway;
import br.com.ariki.music.suggestion.by.weather.gateway.feign.openweathermap.FeignOpenWeatherMapAPI;
import br.com.ariki.music.suggestion.by.weather.gateway.feign.openweathermap.mapper.OpenWeatherMapResponseToTemperature;

@Component
public class OpenWeatherMapDataProvider implements OpenWeatherMapGateway {
	
	private FeignOpenWeatherMapAPI client;
	private String appid;
	private String units;

	public OpenWeatherMapDataProvider(FeignOpenWeatherMapAPI client, Environment environment) {
		this.client = client;
		this.appid = environment.getProperty("openweathermap.appid");
		this.units = environment.getProperty("openweathermap.units");
	}
	
	public Temperature getWeatherByCity(String cityName) {
		return OpenWeatherMapResponseToTemperature.to(client.getWeatherByCity(cityName, appid, units));
	}

	@Override
	public Temperature getWeatherByLatLon(String lat, String lon) {
		return OpenWeatherMapResponseToTemperature.to(client.getWeatherByLatLon(lat, lon, appid, units));
	}

}

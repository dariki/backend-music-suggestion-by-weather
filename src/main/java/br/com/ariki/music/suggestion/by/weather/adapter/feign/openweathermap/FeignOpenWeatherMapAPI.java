package br.com.ariki.music.suggestion.by.weather.adapter.feign.openweathermap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.response.OpenWeatherMapResponse;

@FeignClient(name = "${openweathermap.feign.name}", url = "${openweathermap.feign.url}")
public interface FeignOpenWeatherMapAPI {

	@RequestMapping(method = RequestMethod.GET, value = "/weather")
	OpenWeatherMapResponse getWeather(
			@RequestParam(value = "q") String cityName, 
			@RequestParam(value = "APPID") String appid,
			@RequestParam(value = "units") String units);
}

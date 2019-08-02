package br.com.ariki.music.suggestion.by.weather.config.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {
	
	@Bean
	public RequestInterceptor requestInterceptor() {
	  return requestTemplate -> {
	      requestTemplate.query("APPID", "3d4aabd532def3666be6acb0e3086931");
	      requestTemplate.query("units", "metric");
	  };
	}

}

package br.com.ariki.music.suggestion.by.weather.config.feign.interceptor;

import feign.RequestInterceptor;

public class FeignOneWeatherMapConfig {

	public RequestInterceptor requestOpenWeatherMapInterceptor() {
		return requestTemplate -> {
			requestTemplate.query("APPID", "3d4aabd532def3666be6acb0e3086931");
			requestTemplate.query("units", "metric");
		};
	}

}

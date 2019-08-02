package br.com.ariki.music.suggestion.by.weather.dataprovider.feign.hystrix;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.ariki.music.suggestion.by.weather.dataprovider.feign.openweathermap.FeignOpenWeatherMapAPI;
import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.ErrorDetail;
import br.com.ariki.music.suggestion.by.weather.entrypoint.controller.response.ErrorResponseEntity;

@Component
public class FeignFallback implements FeignOpenWeatherMapAPI{
	
	public ResponseEntity<ErrorResponseEntity> callWhenFallback() {
		
		StringBuilder sugestion = new StringBuilder();
		
		sugestion.append("Mas temos uma sugestão caso isso aconteça. Segue o playlist: ");
		sugestion.append("Dream Theater: , Honor Thy Father");
		sugestion.append("Liquid Tension Experiment: Acid Rain, ");
		sugestion.append("Symphony X: Evolution, ");
		sugestion.append("Dream Theater: Hollow Years, ");
		
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ErrorResponseEntity.builder()
				.error("Não foi possivel conectar com a api OpenWeatherMap")
				.errorDetail(ErrorDetail.builder()
						.message("A api OpenWeatherMap pode estar fora do ar ou com alguma lentidão no serviço")
						.suggestion("Mas temos uma sugestão caso isso aconteça")
						.build())
				.build());
		
	}

}

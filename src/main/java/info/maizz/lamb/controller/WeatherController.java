package info.maizz.lamb.controller;

import info.maizz.lamb.controller.info.CityId;
import info.maizz.lamb.controller.info.Wrapper;
import info.maizz.lamb.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.maizz.lamb.controller.info.WeatherInfo;

@RestController
@RequestMapping("weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;


	@RequestMapping("{cityName}")
	public WeatherInfo getWeatherInfo(@PathVariable("cityName")String cityName){
		String cityId = CityId.getCityIdByName(cityName);
		Wrapper weatherInfo = weatherService.getWeatherInfo(cityId);
		return weatherInfo.getWeatherInfo();
	}

}

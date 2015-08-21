package info.maizz.lamb.service;

import info.maizz.lamb.controller.info.Wrapper;


public interface WeatherService {
	
	public Wrapper getWeatherInfo(String cityId);
	
}

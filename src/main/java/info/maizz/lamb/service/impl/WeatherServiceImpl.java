package info.maizz.lamb.service.impl;

import info.maizz.lamb.controller.info.Wrapper;
import info.maizz.lamb.integration.Exchanger;
import info.maizz.lamb.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceImpl implements WeatherService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Exchanger httpExchanger;

	private String URL_TEMPLATE = "http://www.weather.com.cn/adat/cityinfo/%s.html";

	/**
	 * @param cityId
	 * @return
	 * @see WeatherService#getWeatherInfo(String)
	 */
	@Override
	public Wrapper getWeatherInfo(String cityId) {

		logger.info("要获取的城市编码：{}",cityId);
		String url = String.format(URL_TEMPLATE, cityId);
		Wrapper wrapper = httpExchanger.exchange(url, null, Wrapper.class);
		return wrapper;
	}

}

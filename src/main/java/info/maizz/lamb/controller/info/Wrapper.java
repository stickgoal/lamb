
package info.maizz.lamb.controller.info;

import java.io.Serializable;


public class Wrapper implements Serializable {
	
	private static final long serialVersionUID = 9108144385344351949L;
	
	/**
	 * w
	 */
	private WeatherInfo weatherInfo;
	
	public WeatherInfo getWeatherInfo() {
		return this.weatherInfo;
	}
	
	public void setWeatherInfo(WeatherInfo weatherInfo) {
		this.weatherInfo = weatherInfo;
	}
	
	/**
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wrapper [weatherInfo=");
		builder.append(weatherInfo);
		builder.append("]");
		return builder.toString();
	}
	
}

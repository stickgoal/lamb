package info.maizz.lamb.controller.info;

import java.io.Serializable;

/**
 *
 *
 * @author lucas
 *
 */
public class WeatherInfo implements Serializable {
	
	private static final long serialVersionUID = -8322185984144459158L;

	private String city;
	
	private String weather;
	
	private String temp1;
	
	private String temp2;
	
	private String ptime;
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getWeather() {
		return this.weather;
	}
	
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public String getTemp1() {
		return this.temp1;
	}
	
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	
	public String getTemp2() {
		return this.temp2;
	}
	
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	
	public String getPtime() {
		return this.ptime;
	}
	
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	
	/**
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherInfo [city=");
		builder.append(city);
		builder.append(", weather=");
		builder.append(weather);
		builder.append(", temp1=");
		builder.append(temp1);
		builder.append(", temp2=");
		builder.append(temp2);
		builder.append(", ptime=");
		builder.append(ptime);
		builder.append("]");
		return builder.toString();
	}
	
}

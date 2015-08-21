package info.maizz.lamb.test;

import info.maizz.lamb.controller.info.WeatherInfo;
import info.maizz.lamb.controller.info.Wrapper;
import info.maizz.lamb.integration.HttpExchanger;
import info.maizz.lamb.service.WeatherService;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.when;

public class WeatherServiceTest  extends TestBase{

	public static final String CITY = "重庆1";

	@Autowired
	private WeatherService weatherService;

	@Test
	public void getWeatherInfoTest(){
		mock();

		Wrapper weatherInfo = weatherService.getWeatherInfo("100010");

		assertThat(weatherInfo.getWeatherInfo().getCity()).isEqualTo(CITY);

	}

	private void mock() {
		HttpExchanger httpExchangerMock = Mockito.mock(HttpExchanger.class);

		Wrapper r = new Wrapper();
		WeatherInfo wInfo = new WeatherInfo();
		wInfo.setCity(CITY);
		wInfo.setPtime("08:00");
		wInfo.setTemp1("22℃");
		wInfo.setTemp2("12℃");
		r.setWeatherInfo(wInfo);
		when(httpExchangerMock.<Wrapper>exchange(matches("http://www.weather.com.cn/adat/cityinfo/100010.html"), anyMap(), Matchers.<Class<Wrapper>>any())).thenReturn(r);

		ReflectionTestUtils.setField(weatherService,"httpExchanger",httpExchangerMock);

	}

}

package info.maizz.lamb.test;

import info.maizz.lamb.integration.Exchanger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangerTest extends TestBase {

	@Autowired
	private Exchanger httpExchanger;

	@Test
	public void testExchange() {
		try {
			Object exchange = httpExchanger.exchange(null, null, null);
		} catch (Exception e) {
			assertThat(e).hasMessage("url和resultClass不能为空");
		}
	}


}

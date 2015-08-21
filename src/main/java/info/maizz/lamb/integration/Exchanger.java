package info.maizz.lamb.integration;

import java.util.Map;

/**
 * @author lucas
 */
public interface Exchanger {

	/**
	 * 交换信息
	 * @param url 访问的URL
	 * @param params  参数键值对
	 * @param resultClass 结果java类
	 * @param <T>
	 * @return 指定结果类型的java对象
	 */
	<T> T exchange(String url, Map<String, String> params, Class<T> resultClass);
}

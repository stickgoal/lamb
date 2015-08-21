package info.maizz.lamb.integration;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component("httpExchanger")
public class HttpExchanger implements Exchanger {

	Logger logger = LoggerFactory.getLogger(HttpExchanger.class);

	@Override public <T> T exchange(String url, Map<String, String> params, Class<T> resultClass) {
		logger.info("执行交换 , url :{} , params:{} ,resultClass:{}",url,params,resultClass);

		if (StringUtils.isBlank(url) || resultClass==null){
			throw new IllegalArgumentException("url和resultClass不能为空");
		}

		T resultObject = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();

		url = processUrl(url,params);

		HttpGet get = new HttpGet(url);
		try {

			CloseableHttpResponse response = httpClient.execute(get);
			String resultString = EntityUtils.toString(response.getEntity(), "utf8");

			resultObject = parse(resultClass, resultString);

		} catch (IOException e) {
			logger.error("通讯异常",e);
		} catch (Exception e) {
			logger.error("未知异常", e);
		}

		return resultObject;

	}

	private <T> T parse(Class<T> resultClass, String resultString) {
		logger.info("返回结果 :{}",resultString);
		return JSON.parseObject(resultString, resultClass);
	}

	private String processUrl(String url, Map<String, String> params) {
		if(isEmpty(params)) {
			url+=concatParams(params);
		}
		return url;
	}

	private boolean isEmpty(Map<String, String> params) {
		return params!=null && !params.isEmpty();
	}

	private String concatParams(Map<String, String> params) {
		if(isEmpty(params)){
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("?");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.append(entry.getKey()).append("=").append(entry.getValue());
			builder.append("&");
		}

		return builder.deleteCharAt(builder.length()-1).toString();
	}
}

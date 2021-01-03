package cn.plusman.http.application.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * cn.plusman.http.application.http
 *
 * @author plusman
 * @since 1/2/21
 */
public class HttpClientDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientDemo.class);

    final static CloseableHttpClient httpClient = HttpClientBuilder.create().build();


    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String body = EntityUtils.toString(response.getEntity(), "UTF-8");
            LOGGER.info(body);
        }
    }
}

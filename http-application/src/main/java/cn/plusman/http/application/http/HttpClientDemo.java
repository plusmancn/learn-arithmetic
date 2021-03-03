package cn.plusman.http.application.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
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
@Slf4j
public class HttpClientDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpClientDemo.class);
    
    final static CloseableHttpClient httpClient;
    static {
        RequestConfig requestConfig = RequestConfig.custom()
            // 从连接池获取连接的等待时间
            .setConnectionRequestTimeout(5000)
            .setConnectTimeout(5000)
            .setSocketTimeout(5000)
            .build();
        
        httpClient = HttpClientBuilder
            .create()
            .setDefaultRequestConfig(requestConfig)
            .setMaxConnTotal(1)
            .build();
    }
    
    private static int count  = 0;
    public static void postDemo(int time) throws IOException {
        log.info("enter {}", count++);
        
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/test/block?time=" + time);
        
        // 关闭资源释放
        CloseableHttpResponse response = httpClient.execute(httpGet);
        
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity, "UTF-8");
        log.info("count: {}, {}", count, body);
    }

    public static void main(String[] args) {
        try {
            postDemo(2000);
        } catch (IOException e) {
            log.error("catch connection timeout", e);
        }
        
        try {
            postDemo(2000);
        } catch (IOException e) {
            log.error("catch connection timeout", e);
        }
        
        // ExecutorService executors =  Executors.newFixedThreadPool(10);
        // for (int i = 0; i < 10; i++) {
        //     executors.execute(new Runnable() {
        //         @Override
        //         public void run() {
        //             try {
        //                 postDemo(2000);
        //             } catch (IOException e) {
        //                 log.error("catch error {}" , e);
        //             }
        //         }
        //     });
        // }
    }
}

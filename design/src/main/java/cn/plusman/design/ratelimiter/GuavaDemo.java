package cn.plusman.design.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import com.sun.tools.doclets.internal.toolkit.FieldWriter;

import java.io.InputStream;
import java.time.Duration;

/**
 * cn.plusman.design.ratelimiter
 *
 * @author plusman
 * @since 12/26/20
 */
public class GuavaDemo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(2.0, Duration.ofSeconds(1L));
        while (true) {
            Double d = limiter.acquire(10);
            System.out.println(System.currentTimeMillis() + ":" + d);
        }

        // 了解 RateLimiter 限流算法
    }

}

package cn.plusman.springdemo.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * cn.plusman.springdemo.observer
 *
 * @author plusman
 * @since 12/13/20
 */

@SpringBootTest
class DemoPublisherTest {
    @Autowired
    DemoPublisher demoPublisher;

    @BeforeEach
    void setUp() {
    }

    @Test
    void publishEvent() {
        DemoEvent demoEvent = new DemoEvent(Arrays.asList(1, 2, 3), "hello world");
        demoPublisher.publishEvent(demoEvent);
    }
}
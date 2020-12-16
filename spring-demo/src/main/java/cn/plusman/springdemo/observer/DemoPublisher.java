package cn.plusman.springdemo.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * cn.plusman.design.observer
 *
 * @author plusman
 * @since 12/13/20
 */

@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(DemoEvent demoEvent) {
        this.applicationContext.publishEvent(demoEvent);
    }
}

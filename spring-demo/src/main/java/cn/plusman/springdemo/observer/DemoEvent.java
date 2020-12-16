package cn.plusman.springdemo.observer;

import org.springframework.context.ApplicationEvent;

/**
 * cn.plusman.design.observer
 *
 * @author plusman
 * @since 12/13/20
 */

public class DemoEvent extends ApplicationEvent {
    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}

package cn.plusman.spring.explore.message;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author plusman
 * @since 2021/4/20 5:33 PM
 */
@Component
public class MessageServiceImpl implements MessageService, ApplicationContextAware {
    @Override
    public String getMessage() {
        return "hello world";
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // donothing
        System.out.println("application aware");
    }
}

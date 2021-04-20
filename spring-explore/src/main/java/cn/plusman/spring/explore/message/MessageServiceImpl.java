package cn.plusman.spring.explore.message;

import org.springframework.stereotype.Component;

/**
 * @author plusman
 * @since 2021/4/20 5:33 PM
 */
@Component
public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "hello world";
    }
}

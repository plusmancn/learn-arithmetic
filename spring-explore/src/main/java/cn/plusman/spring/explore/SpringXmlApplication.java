package cn.plusman.spring.explore;

import cn.plusman.spring.explore.message.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author plusman
 * @since 2021/4/20 4:37 PM
 */
public class SpringXmlApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-file.xml");
    
        System.out.println("context 启动成功");
    
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}

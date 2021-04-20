package cn.plusman.spring.explore;

import cn.plusman.spring.explore.message.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author plusman
 * @since 2021/4/20 5:42 PM
 */
public class SpringAnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.plusman.spring.explore");
        
        System.out.println("context 启动成功");
    
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}

package cn.plusman.learn.java.override;

import java.util.OptionalDouble;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author plusman
 * @since 2021/7/13 11:07 PM
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(System.out::println).start();
    
        // ExecutorService exec = Executors.newCachedThreadPool();
        // exec.submit(System.out::println);
    }
}

package cn.plusman.interview.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/31/20
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
    }
}

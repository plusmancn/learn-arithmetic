package cn.plusman.interview.concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cn.plusman.interview.ThreadStartTwice
 *
 * @author plusman
 * @since 12/28/20
 */
public class AlternativePrintV1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(
            1,2,3,4,5,6,7,8,9
        ));
    
        ReentrantLock lockA = new ReentrantLock();
        
        MyThread myThread = new MyThread(lockA, queue);
        
        new Thread(myThread, "ThreadA").start();
        new Thread(myThread, "ThreadB").start();
    }
    
    private static class MyThread implements Runnable {
        private Object lock;
        private Queue<Integer> queue;
    
        public MyThread(Object lock, Queue<Integer> queue) {
            this.lock = lock;
            this.queue = queue;
        }
    
        @Override
        public void run() {
            synchronized (lock) {
                while (!queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + ": " + queue.poll());
                    lock.notifyAll();
                    try {
                        if (!queue.isEmpty()) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

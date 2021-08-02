package cn.plusman.interview.concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 多米诺骨牌
 * @author plusman
 * @since 2021/8/2 9:56 AM
 */
public class AlternativePrintV2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(
            1,2,3,4,5,6,7,8,9,10
        ));
    
        // 初始化
        MyThread myThreadA = new MyThread(queue);
        MyThread myThreadB = new MyThread(queue);
        MyThread myThreadC = new MyThread(queue);
        
        // 注入
        myThreadA.setNext(myThreadB);
        myThreadB.setNext(myThreadC);
        myThreadC.setNext(myThreadA);
        
        new Thread(myThreadA, "ThreadA").start();
        new Thread(myThreadB, "ThreadB").start();
        new Thread(myThreadC, "ThreadC").start();
        
        synchronized (myThreadA) {
            myThreadA.notify();
        }
    }
    
    
    private static class MyThread implements Runnable {
        private Object next;
        private Queue<Integer> queue;
        
        public MyThread(Queue<Integer> queue) {
            this.queue = queue;
        }
    
        public void setNext(Object next) {
            this.next = next;
        }
    
        @Override
        public void run() {
            synchronized (this) {
                while (!queue.isEmpty()) {
                    try {
                        this.wait();
                        if (!queue.isEmpty()) {
                            System.out.println(Thread.currentThread().getName() + ": " + queue.poll());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (next) {
                        next.notifyAll();
                    }
                }
            }
        }
    }
}

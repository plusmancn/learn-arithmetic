package cn.plusman.interview.concurrency;

import java.util.concurrent.SynchronousQueue;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/30/20
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Thread t1 = new Thread(new ProducerTask(queue));
        Thread t2 = new Thread(new ConsumerTask(queue));

        t1.start();
        t2.start();
    }

    static class ProducerTask implements Runnable {
        private SynchronousQueue<String> synchronousQueue;

        public ProducerTask(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                System.out.println("try to put string");
                synchronousQueue.put("hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ConsumerTask implements Runnable {
        private SynchronousQueue<String> synchronousQueue;

        public ConsumerTask(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {

            String s = null;
            try {
                s = synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }
    }
}

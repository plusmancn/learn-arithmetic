package cn.plusman.interview.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/29/20
 */
public class CountDownLatchSample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Action...GO!");

        final int batch = 5;
        for (int i = 0; i < 12;) {
            CountDownLatch batchWait = new CountDownLatch(5);
            for (int j = 0; j < batch;j++) {
                i++;
                Thread t = new Thread(new LatchWorker(batchWait));
                t.start();
            }
            batchWait.await();

            System.out.println("Next Batch");
        }
    }
}

class LatchWorker implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    public LatchWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        log("is waiting for a permit!");
        countDownLatch.countDown();
        log("acquired a permit!");
        log("executed!");
    }
    private void log(String msg){
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}
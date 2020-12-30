package cn.plusman.interview.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/29/20
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        System.out.println("Action...GO!");
        CyclicBarrier cb = new CyclicBarrier(5);
        for (int i = 0; i < 10; i++) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.execute(new Car5(cb));
        }
    }
}


class Car5 implements Runnable {
    private final static AtomicInteger seq = new AtomicInteger(1);
    private String name;
    private CyclicBarrier cyclicBarrier;

    public Car5(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            int current = seq.getAndIncrement();
            System.out.println(current + "准备发车，等待其他车辆.....");
            cyclicBarrier.await();
            System.out.println(current + "车队集合完毕，发车！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private void log(String msg){
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}

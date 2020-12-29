package cn.plusman.interview.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/27/20
 */

public class ThreadSafeSample {
    public int sharedState;
    public void nonSafeAction() {
        while (sharedState < 100000) {
            synchronized (this) {
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter - 1) {
                    System.out.printf("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        lock.newCondition();

        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(() -> sample.nonSafeAction());
        Thread threadB = new Thread(() -> sample.nonSafeAction());
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
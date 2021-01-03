package cn.plusman.interview.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/31/20
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);

        ai.getAndIncrement();
    }
}

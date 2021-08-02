package cn.plusman.jcip.chapter15;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * @author plusman
 * @since 2021/8/1 11:58 AM
 */
@ThreadSafe
public class SimulatedCAS {
    @GuardedBy("this") private int value;
    
    public synchronized int get() {
        return value;
    }
    
    public synchronized int compareAndSwap(int expectedValue,
                                           int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue)
            value = newValue;
        return oldValue;
    }
    
    public synchronized boolean compareAndSet(int expectedValue,
                                              int newValue) {
        return (expectedValue
            == compareAndSwap(expectedValue, newValue));
    }
}

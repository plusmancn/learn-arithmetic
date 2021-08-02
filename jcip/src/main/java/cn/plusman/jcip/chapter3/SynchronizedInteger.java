package cn.plusman.jcip.chapter3;

import javax.annotation.concurrent.GuardedBy;

/**
 * @author plusman
 * @since 2021/8/1 10:49 AM
 */
public class SynchronizedInteger {
    @GuardedBy("this") private int value;
    
    public synchronized int get() {
        return value;
    }
    
    public synchronized void set(int value) {
        this.value = value;
    }
}

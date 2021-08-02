package cn.plusman.jcip.chapter15;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author plusman
 * @since 2021/8/1 12:12 PM
 */
@ThreadSafe
public class CasCounter {
    private SimulatedCAS value;
    
    public int getValue() {
        return value.get();
    }
    
    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}

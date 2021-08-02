package cn.plusman.jcip.chapter15;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author plusman
 * @since 2021/8/1 1:52 PM
 */
@ThreadSafe
public class ReentrantLockPseudoRandom extends PseudoRandom {
    private final Lock lock = new ReentrantLock(false);
    private int seed;
    
    ReentrantLockPseudoRandom(int seed) {
        this.seed = seed;
    }
    
    public int nextInt(int n) {
        lock.lock();
        try {
            int s = seed;
            seed = calculateNext(s);
            int remainder = s % n;
            return remainder > 0 ? remainder : remainder + n;
        } finally {
            lock.unlock();
        }
    }
}
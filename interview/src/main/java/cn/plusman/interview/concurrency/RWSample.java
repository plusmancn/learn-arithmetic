package cn.plusman.interview.concurrency;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * cn.plusman.interview.concurrency
 *
 * @author plusman
 * @since 12/27/20
 */
public class RWSample {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    public String get(String key) {
        System.out.println("读锁锁定！");
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String put(String key, String entry) {
        System.out.println("写锁锁定！");
        w.lock();
        try {
            return m.put(key, entry);
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        RWSample demo = new RWSample();

        demo.put("A", "a");
        demo.get("A");
    }
}


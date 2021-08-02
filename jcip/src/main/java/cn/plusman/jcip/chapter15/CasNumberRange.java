package cn.plusman.jcip.chapter15;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author plusman
 * @since 2021/8/1 1:46 PM
 */
@ThreadSafe
public class CasNumberRange {
    @Immutable
    private static class IntPair {
        // INVARIANT: lower <= upper
        final int lower;
        final int upper;
        
        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    private final AtomicReference<IntPair> values =
        new AtomicReference<>(new IntPair(0, 0));
    
    public int getLower() {
        return values.get().lower;
    }
    
    public int getUpper() {
        return values.get().upper;
    }
    
    public void setLower(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper)
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }
    
    public void setUpper(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i < oldv.lower)
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            IntPair newv = new IntPair(oldv.lower, i);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
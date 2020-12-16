package cn.plusman.interview.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * cn.plusman.interview.reference
 *
 * @author plusman
 * @since 12/13/20
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object counter = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue<>();

        PhantomReference<Object> p = new PhantomReference<>(counter, referenceQueue);
        counter = null;
        System.gc();

        try {
            Reference<Object> ref = referenceQueue.remove(1000L);
            if(ref != null) {
                System.out.println("ref is not null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

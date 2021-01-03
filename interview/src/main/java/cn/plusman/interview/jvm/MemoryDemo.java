package cn.plusman.interview.jvm;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * cn.plusman.interview.jvm
 *
 * @author plusman
 * @since 1/3/21
 */
public class MemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        int size = 1;

        List<byte[]> container = new LinkedList<>();

        // HEAP SPACE
        for(int j = 1;; j++) {
            byte[] b = new byte[1024 * 1024 * size];
            for (int i = 0; i < b.length; i++) {
                b[i] = 'a';
            }

            container.add(b);
            TimeUnit.SECONDS.sleep(1);

            System.out.println("already alloc: " + j * size + "M");
        }
    }
}

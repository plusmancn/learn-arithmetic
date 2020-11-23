package cn.plusman.zktest;

import lombok.SneakyThrows;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * cn.plusman.zktest
 *
 * @author plusman
 * @since 2020/11/20
 */
public class Demo {

    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZKManager zkManager = new ZKManagerImpl();

        (new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("1in");
                zkManager.create("/a", "axxx".getBytes(), CreateMode.EPHEMERAL);
                Thread.sleep(4000);
                System.out.println("4s");
            }
        })).start();


        (new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("2in");
                zkManager.create("/b", "bxxx".getBytes(), CreateMode.EPHEMERAL);
                Thread.sleep(8000);
                System.out.println("8s");
            }
        })).start();


        Thread.yield();
        Thread.sleep(10000);
    }
}

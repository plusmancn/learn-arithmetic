package cn.plusman.zktest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;

/**
 * cn.plusman.zktest
 *
 * @author plusman
 * @since 2020/11/20
 */
public interface ZKManager {
    void create(String path, byte[] data, CreateMode mode) throws KeeperException, InterruptedException;

    Object getZNodeData(String path, boolean watchFlag);
    void update(String path, byte[] data) throws KeeperException, InterruptedException;
}

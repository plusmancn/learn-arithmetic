package cn.plusman.zktest;

import lombok.SneakyThrows;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * cn.plusman.zktest
 *
 * @author plusman
 * @since 2020/11/20
 */
public class ZKManagerImpl implements ZKManager {
    private static ZooKeeper zooKeeper;
    private static ZKConnection zkConnection;

    public ZKManagerImpl() {
        initialize();
    }

    @SneakyThrows
    private void initialize() {
        zkConnection = new ZKConnection();
        zooKeeper = zkConnection.connect("macair.plusman.cn:2181");
    }

    @Override
    public void create(String path, byte[] data, CreateMode mode) throws KeeperException, InterruptedException {
        zooKeeper.create(
            path,
            data,
            ZooDefs.Ids.OPEN_ACL_UNSAFE,
            mode
        );
    }

    @SneakyThrows
    @Override
    public Object getZNodeData(String path, boolean watchFlag) {
        byte[] b = null;
        b = zooKeeper.getData(path, null, null);
        return new String(b, "UTF-8");
    }

    @Override
    public void update(String path, byte[] data) throws KeeperException, InterruptedException {
        int version = zooKeeper.exists(path, true).getVersion();
        zooKeeper.setData(path, data, version);
    }
}

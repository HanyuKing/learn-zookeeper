import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by Hanyu on 2017/8/9.
 */
public class HelloWorld implements Watcher {
    private static final int TIME_OUT = 3000;
    private static final String HOST = "192.168.147.128:2181";
    private static ZooKeeper zookeeper = null;
    public static void main(String[] args) throws Exception {
        Watcher w = new HelloWorld();
        zookeeper = new ZooKeeper(HOST, TIME_OUT, w);
        if(zookeeper.exists("/test", false) == null) {
            zookeeper.create("/test", "znode1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        Stat stat = new Stat();

        for(int i = 0; i < 20; i++) {
            zookeeper.getData("/test", true, stat);
            System.out.println(stat.getVersion());
            zookeeper.setData("/test", "hanyu旱雨".getBytes(), stat.getVersion());
        }

    }

    public void process(WatchedEvent event) {
        System.out.println("watcher hanyu ");
        try {
            zookeeper.getChildren(event.getPath(), true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

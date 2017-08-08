import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by Hanyu on 2017/8/9.
 */
public class HelloWorld {
    private static final int TIME_OUT = 3000;
    private static final String HOST = "192.168.147.128:2181";

    public static void main(String[] args) throws Exception {
        ZooKeeper zookeeper = new ZooKeeper(HOST, TIME_OUT, null);
        System.out.println("=========创建节点===========");
        if(zookeeper.exists("/test", false) == null) {
            System.out.println("===========开始创建节点=========");
            zookeeper.create("/test", "znode1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println("=============查看节点是否安装成功===============");
        System.out.println(new String(zookeeper.getData("/test", false, null)));
    }
}

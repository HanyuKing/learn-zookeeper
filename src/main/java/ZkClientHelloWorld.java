import org.I0Itec.zkclient.ZkClient;

/**
 * @author wanghanyu
 * @create 2017-08-28 12:11
 */
public class ZkClientHelloWorld {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("");
        zkClient.createPersistent("", true);
        zkClient.deleteRecursive("");
    }
}

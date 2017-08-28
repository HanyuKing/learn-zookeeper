
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author wanghanyu
 * @create 2017-08-28 17:50
 */
public class CuratorHelloWorld {
    public static void main(String[] args) {
        CuratorFrameworkFactory.newClient("", new ExponentialBackoffRetry(1000, 3))
                .start();
    }
}

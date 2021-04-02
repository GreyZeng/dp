package singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式
 * 按需初始化
 * 用synchronized解决线程不安全的问题，但是带来了效率的降低？
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}

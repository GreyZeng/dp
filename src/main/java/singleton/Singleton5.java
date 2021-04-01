package singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式
 * synchronized代码块，提升效率，但是却带来了线程不安全的问题
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
    public static void main(String[] args) {
        final Set<Singleton5> set = new HashSet<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                set.add(Singleton5.getInstance());
            });
        }
        System.out.println(set.size());
    }
}

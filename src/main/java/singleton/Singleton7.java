package singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 静态内部类方式，JVM保证单例，加载外部类时不会加载内部类，这样可以实现懒加载
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton7 {
    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    public static void main(String[] args) {
        final Set<Singleton8> set = new HashSet<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                set.add(Singleton8.INSTANCE);
            });
        }
        System.out.println(set.size());
    }

}

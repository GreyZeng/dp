package singleton;

/**
 * 饿汉式单例模式
 * 类加载的时候初始化
 * 可以通过反射破坏
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

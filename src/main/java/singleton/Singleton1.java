package singleton;

/**
 * 饿汉式单例模式
 * 类加载的时候就会初始化这个实例
 * 可以通过反射破坏
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}

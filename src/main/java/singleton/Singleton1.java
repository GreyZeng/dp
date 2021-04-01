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

    // 这种方式可以通过反射破坏
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("singleton.Singleton1", true, Thread.currentThread().getContextClassLoader());
        Singleton1 instance1 = (Singleton1) aClass.newInstance();
        Singleton1 instance2 = (Singleton1) aClass.newInstance();
        System.out.println(instance1 == instance2);
    }
}

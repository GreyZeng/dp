package singleton;

/**
 * DCL,Volatile必需，为了防止指令重排，生成一个半初始化的的实例，导致生成两个实例
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton6 {
    private volatile static Singleton6 INSTANCE;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}

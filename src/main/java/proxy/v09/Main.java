package proxy.v09;

import java.lang.reflect.Proxy;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class Main {
    public static void main(String[] args) {
        Movable tank = new Tank();

        //reflection 通过二进制字节码分析类的属性和方法

        Movable m = (Movable) Proxy.newProxyInstance(Movable.class.getClassLoader(),
                new Class[]{Movable.class},
                new MovableProxy(tank)
        );

        m.move();
        m.go();
    }
}

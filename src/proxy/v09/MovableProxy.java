package proxy.v09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class MovableProxy implements InvocationHandler {
    private Movable movable;

    public MovableProxy(Movable movable) {
        this.movable = movable;
    }

    public void before() {
        System.out.println("before , do sth");
    }

    public void after() {
        System.out.println("after , do sth");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(movable, args);
        after();
        return o;
    }
}

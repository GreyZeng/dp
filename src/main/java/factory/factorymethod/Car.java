package factory.factorymethod;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/4/2
 * @since
 */
public class Car implements Movable {

    @Override
    public void go() {
        System.out.println("car go");
    }
}

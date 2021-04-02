package factory.abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Car extends Transportation {
    @Override
    protected void go() {
        System.out.println("car go");
    }
}

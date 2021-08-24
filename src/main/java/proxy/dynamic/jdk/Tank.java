package proxy.dynamic.jdk;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class Tank implements Movable {


    @Override
    public void move() {
        System.out.println("tank move");
    }

    @Override
    public void go() {
        System.out.println("tank go");
    }
}

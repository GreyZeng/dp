package proxy.static_;

public class TankLogProxy implements Moveable {
    private Moveable m;

    public TankLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("log before");
        m.move();
        System.out.println("log after");
    }
}

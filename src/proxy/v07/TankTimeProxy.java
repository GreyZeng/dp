package proxy.v07;

public class TankTimeProxy implements Moveable {
    private Moveable m;

    public TankTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("time is " + (end - start));
    }
}

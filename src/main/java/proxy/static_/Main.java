package proxy.static_;

public class Main {
    public static void main(String[] args) {
        new TankLogProxy(new Tank()).move();
        new TankTimeProxy(new Tank()).move();
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}

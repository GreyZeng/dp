package proxy.v07;

public class Tank implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tank move");
    }
}

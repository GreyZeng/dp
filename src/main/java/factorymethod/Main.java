package factorymethod;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
        Moveable move = new CarFactory().create();
        move.go();
        move = new BusFactory().create();
        move.go();
    }
}

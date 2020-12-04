package factorymethod;


public class BusFactory {
    Moveable create() {
        return new Bus();
    }
}

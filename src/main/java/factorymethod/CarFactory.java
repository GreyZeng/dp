package factorymethod;


public class CarFactory {
    Moveable create() {
        return new Car();
    }
}

package factory.factorymethod;


import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        new HpMouseFactory().createMouse().sayHi();
        new DellMouseFactory().createMouse().sayHi();
        new IBMMouseFactory().createMouse().sayHi();

        MovableFactory.create(Car::new).go();
        MovableFactory.create(Ship::new).go();
    }

    static class MovableFactory {
        // 使用 Supplier 实现单例模式
        public static Movable create(Supplier<? extends Movable> supplier) {
            return supplier.get();
        }
    }
}

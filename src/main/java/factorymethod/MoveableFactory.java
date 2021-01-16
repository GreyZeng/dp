package factorymethod;

import java.util.function.Supplier;

public class MoveableFactory {
    public  Moveable create(Supplier<? extends Moveable> supplier) {
       return  supplier.get();
    }
}

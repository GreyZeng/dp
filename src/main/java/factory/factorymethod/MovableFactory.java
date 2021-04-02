package factory.factorymethod;

import java.util.function.Supplier;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/4/2
 * @since
 */
public class MovableFactory {
    public static Movable create(Supplier<? extends Movable> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        MovableFactory.create(Car::new).go();
        MovableFactory.create(() -> new Ship()).go();
    }
}

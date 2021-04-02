package factory.factorymethod;

public class LenovoMouseFactory  implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}

package factory.factorymethod;
 

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}

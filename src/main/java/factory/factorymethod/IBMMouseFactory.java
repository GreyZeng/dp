package factory.factorymethod;

public class IBMMouseFactory extends LenovoMouseFactory {
    @Override
    public Mouse createMouse(){
        return new IBMMouse();
    }
}

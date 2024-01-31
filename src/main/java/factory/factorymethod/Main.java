package factory.factorymethod;


public class Main {
    public static void main(String[] args) {
        new HpMouseFactory().createMouse().sayHi();
        new DellMouseFactory().createMouse().sayHi();
        new IBMMouseFactory().createMouse().sayHi();
    }
}

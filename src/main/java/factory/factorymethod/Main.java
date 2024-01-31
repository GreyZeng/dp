package factory.factorymethod;


public class Main {
    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        MouseFactory mf2 = new DellMouseFactory();
        MouseFactory mf3 = new IBMMouseFactory();
        mf.createMouse().sayHi();
        mf2.createMouse().sayHi();
        mf3.createMouse().sayHi();
    }
}

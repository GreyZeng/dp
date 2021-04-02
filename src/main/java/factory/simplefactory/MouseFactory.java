package factory.simplefactory;

public class MouseFactory {
    public static Mouse createMouse(int type) {
        switch (type) {
            case 1:
                return new HpMouse();
            case 2:
                return new LenovoMouse();
            case 0:
            default:
                return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }
}

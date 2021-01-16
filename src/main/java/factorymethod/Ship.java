package factorymethod;

public class Ship implements Moveable{
    private String name;
    public Ship(String name) {
        this.name = name;
    }
    @Override
    public void go() {
        System.out.println(name + " go");
    }
}

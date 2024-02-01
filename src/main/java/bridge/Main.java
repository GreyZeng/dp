package bridge;

public class Main {
    public static void main(String[] args) {
        new GG().chase(new MM());


        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

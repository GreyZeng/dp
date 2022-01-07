package decorator;

public class Main {
    public static void main(String[] args) throws Exception {
        new RedSharpDecorator(new Circle()).draw();
        new RedSharpDecorator(new Rectangle()).draw();
    }
}

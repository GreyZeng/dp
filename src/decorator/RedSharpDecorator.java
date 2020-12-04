package decorator;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class RedSharpDecorator extends SharpDecorator {

    public RedSharpDecorator(Sharp decoratedSharp) {
        super(decoratedSharp);
    }

    private static void redIt() {
        System.out.println("[RED]");
    }

    @Override
    protected void draw() {
        redIt();
        this.decoratedSharp.draw();
        redIt();
    }
}

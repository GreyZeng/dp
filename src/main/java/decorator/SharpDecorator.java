package decorator;

/**
 * @author Grey
 * @date 2020/4/14
 */
public abstract class SharpDecorator extends Sharp {
    protected Sharp decoratedSharp;

    public SharpDecorator(Sharp decoratedSharp) {
        this.decoratedSharp = decoratedSharp;
    }
}

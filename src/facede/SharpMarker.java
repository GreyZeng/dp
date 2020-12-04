package facede;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class SharpMarker {
    private Sharp circle;
    private Sharp rectangle;

    public SharpMarker(Sharp circle, Sharp rectangle) {
        this.circle = circle;
        this.rectangle = rectangle;
    }

    public void draw() {
        circle.draw();
        rectangle.draw();
    }
}

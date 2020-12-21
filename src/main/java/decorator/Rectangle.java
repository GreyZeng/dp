package decorator;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Rectangle extends Sharp {
    @Override
    protected void draw() {
        System.out.println("Rectangle");
    }
}

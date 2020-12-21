package decorator;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Circle extends Sharp {
    @Override
    protected void draw() {
        System.out.println("Circle");
    }
}

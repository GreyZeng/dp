package principle.ocp;

/**
 * 符合开闭原则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class GraphicEditor1 {
    public void draw(Shape shape) {
        shape.draw();
    }

    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("画矩形");
        }
    }

    class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("画圆形");
        }
    }
}

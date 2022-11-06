package principle.ocp;

/**
 * 不符合开闭原则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class GraphicEditor {
    public void draw(Shape shape) {
        if (shape.mType == 1) {
            drawRectangle();
        } else if (shape.mType == 2) {
            drawCircle();
        }
        // ... 每次增加一种类型，这里的代码就要加一个if分支。不符合开闭原则
    }

    public void drawRectangle() {
        System.out.println("画长方形");
    }

    public void drawCircle() {
        System.out.println("画圆形");
    }

    class Shape {
        int mType;
    }

    class Rectangle extends Shape {
        Rectangle() {
            super.mType = 1;
        }
    }

    class Circle extends Shape {
        Circle() {
            super.mType = 2;
        }
    }
}

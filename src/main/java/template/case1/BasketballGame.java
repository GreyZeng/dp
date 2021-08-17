package template.case1;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class BasketballGame extends Game {
    @Override
    protected void init() {
        System.out.println("basketball init");
    }

    @Override
    protected void start() {

        System.out.println("basketball start");
    }

    @Override
    protected void end() {

        System.out.println("basketball end");
    }
}

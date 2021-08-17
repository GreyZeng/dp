package template.case1;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class FootballGame extends Game {
    @Override
    protected void init() {
        System.out.println("football init");
    }

    @Override
    protected void start() {

        System.out.println("football start");
    }

    @Override
    protected void end() {

        System.out.println("football end");
    }
}

package template.case1;

/**
 * @author Grey
 * @date 2020/4/17
 */
public abstract class Game {
    protected abstract void init();

    protected abstract void start();

    protected abstract void end();

    protected final void play() {
        init();
        start();
        end();
    }
}

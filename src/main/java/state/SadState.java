package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class SadState implements State {

    @Override
    public void cry() {
        System.out.println("Sad cry");
    }

    @Override
    public void smile() {
        System.out.println("Sad smile");
    }

    @Override
    public void say() {
        System.out.println("Sad say");
    }
}

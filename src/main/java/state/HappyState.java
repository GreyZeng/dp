package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class HappyState implements State {

    @Override
    public void cry() {
        System.out.println("happy cry");
    }

    @Override
    public void smile() {
        System.out.println("happy smile");
    }

    @Override
    public void say() {
        System.out.println("happy say");
    }
}

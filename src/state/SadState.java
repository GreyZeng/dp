package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class SadState extends State {

    @Override
    void cry() {
        System.out.println("Sad cry");
    }

    @Override
    void smile() {
        System.out.println("Sad smile");
    }

    @Override
    void say() {
        System.out.println("Sad say");
    }
}

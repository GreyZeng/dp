package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class HappyState extends State {

    @Override
    void cry() {
        System.out.println("happy cry");
    }

    @Override
    void smile() {
        System.out.println("happy smile");
    }

    @Override
    void say() {
        System.out.println("happy say");
    }
}

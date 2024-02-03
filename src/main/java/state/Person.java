package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Person {
    private final State state;

    public Person(State state) {
        this.state = state;
    }

    void cry() {
        state.cry();
    }

    void smile() {
        state.smile();
    }

    void say() {
        state.say();
    }
}

package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person(new SadState());
        person.cry();
        person.say();
        person.smile();
        person = new Person(new HappyState());
        person.cry();
        person.say();
        person.smile();

    }
}

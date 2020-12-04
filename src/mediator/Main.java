package mediator;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("Peter");
        user.sendMessage("Hello ");
        user = new User("Harry");
        user.sendMessage("Hi");
    }
}

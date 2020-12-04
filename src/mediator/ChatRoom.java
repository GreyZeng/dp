package mediator;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class ChatRoom {
    public static void showMessage(User user, String content) {
        System.out.println("user :" + user.getName() + " send a message, content is " + content);
    }
}

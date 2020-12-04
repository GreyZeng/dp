package mediator;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class User {


    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String content) {
        ChatRoom.showMessage(this, content);
    }

    public String getName() {
        return this.name;
    }
}

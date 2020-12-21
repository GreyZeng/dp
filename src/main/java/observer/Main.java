package observer;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new Listener1());
        button.addActionListener(new Listener2());
        button.buttonPressed();
    }
}

package observer;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Listener1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Listener 1 listened it source: [" + event.getSource() + "], when is [" + event.getWhen() + "]");
    }
}

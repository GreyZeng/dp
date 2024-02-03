package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class Button {
    private final List<ActionListener> listeners = new ArrayList<>();

    public void addActionListener(ActionListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public String toString() {
        return "Button{" +
                "listeners=" + listeners +
                '}';
    }

    public void buttonPressed() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        listeners.forEach(item -> item.actionPerformed(event));
    }
}

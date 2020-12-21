package observer;

/**
 * @author Grey
 * @date 2020/4/14
 */
public class ActionEvent {
    private long when;
    private Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }

}

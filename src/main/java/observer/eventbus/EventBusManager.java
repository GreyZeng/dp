package observer.eventbus;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/8/24
 * @since
 */
public class EventBusManager {
    private static EventBus eventBus = new EventBus();

    public static EventBus getInstance(){
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }


}

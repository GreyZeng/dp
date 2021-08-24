package observer.eventbus;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/8/24
 * @since
 */
public class DataObserver1 {
    @Subscribe
    public void handleEvent(String msg) {
        System.out.println("Observer1: " + msg);
    }

}

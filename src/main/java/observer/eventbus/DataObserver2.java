package observer.eventbus;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/8/24
 * @since
 */
public class DataObserver2 {

    @Subscribe
    public void handleEvent(Integer num) {
        System.out.println("Observer2: "+num);
    }
}
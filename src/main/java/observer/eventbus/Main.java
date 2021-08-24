package observer.eventbus;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/8/24
 * @since
 */
public class Main {
    public static void main(String[] args) {
        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        //注册观察者
        EventBusManager.register(observer1);
        EventBusManager.register(observer2);

        //添加事件
        EventBusManager.post("hello world!");
        EventBusManager.post(12345);
  
    }
}

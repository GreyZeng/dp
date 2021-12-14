package proxy.static_.db;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("create order finished");
        return 1;
    }
}

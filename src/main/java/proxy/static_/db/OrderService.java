package proxy.static_.db;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since
 */
public class OrderService implements IOrderService {
    private OrderDao dao;

    public OrderService() {
        dao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("create order");
        return dao.insert(order);
    }
}

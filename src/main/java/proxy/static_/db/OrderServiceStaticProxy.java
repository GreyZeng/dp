package proxy.static_.db;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since
 */
public class OrderServiceStaticProxy implements IOrderService {
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        int dbRouter = Integer.parseInt(YEAR_FORMAT.format(new Date(time)));
        System.out.println("静态代理类自动分配到〖DB_" + dbRouter + "〗数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("after proxy");
    }

    private void before() {
        System.out.println("before proxy");
    }


}

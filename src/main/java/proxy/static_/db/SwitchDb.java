package proxy.static_.db;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 静态代理实现动态切换数据源
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since 1.8
 */
public class SwitchDb {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    public static void main(String[] args) throws Exception {
        Order order = new Order();
        Date date = FORMAT.parse("2021/10/11");
        order.setCreateTime(date.getTime());
        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);
    }
}

package proxy.static_.db;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since
 */
public class Order {
    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Object orderInfo;
    private Long createTime;
    private String id;
}

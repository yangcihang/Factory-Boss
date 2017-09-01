package boss_android.transparent_factory.order.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class OrderListResponse implements Serializable {
    private List<OrderListModel> orders;
    private int totalCount;

    public void setOrders(List<OrderListModel> orders) {
        this.orders = orders;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<OrderListModel> getOrders() {
        return orders;
    }
}

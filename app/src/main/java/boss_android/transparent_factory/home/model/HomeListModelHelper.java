package boss_android.transparent_factory.home.model;

import boss_android.transparent_factory.home.HomeFragment;
import boss_android.transparent_factory.network.NetWork;
import boss_android.transparent_factory.network.ResponseCallback;
import boss_android.transparent_factory.order.fragment.OrderListContentFragment;
import boss_android.transparent_factory.order.model.OrderListResponse;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class HomeListModelHelper {
    /**
     * 请求进行中的订单列表
     */
    public static void requestProcessingData(String page, String size, final HomeFragment callback) {
        NetWork.getService().requestProcessingList(page, size).enqueue(new ResponseCallback<OrderListResponse>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                OrderListResponse response = (OrderListResponse) data;
                callback.onDataLoadedSuccess(response.getOrders(), response.getTotalCount());
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }
}

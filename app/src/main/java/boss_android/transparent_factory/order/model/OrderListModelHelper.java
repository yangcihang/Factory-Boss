package boss_android.transparent_factory.order.model;

import boss_android.transparent_factory.network.NetWork;
import boss_android.transparent_factory.network.ResponseCallback;
import boss_android.transparent_factory.order.fragment.OrderListContentFragment;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class OrderListModelHelper {
    /**
     * 未开始的订单列表
     */
    public static void requestUnstartData(String page, String size, final OrderListContentFragment callback) {
        NetWork.getService().requestUnstartList(page, size).enqueue(new ResponseCallback<OrderListResponse>(new ResponseCallback.DataCallback() {
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

    /**
     * 已经结束的订单列表
     */
    public static void requestFinishedData(String page, String size, final OrderListContentFragment callback) {
        NetWork.getService().requestFinishedList(page, size).enqueue(new ResponseCallback<OrderListResponse>(new ResponseCallback.DataCallback() {
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

    /**
     * 请求进行中的订单列表
     */
    public static void requestProcessingData(String page, String size, final OrderListContentFragment callback) {
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

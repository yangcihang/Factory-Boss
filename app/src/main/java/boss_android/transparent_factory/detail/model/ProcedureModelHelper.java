package boss_android.transparent_factory.detail.model;

import boss_android.transparent_factory.detail.OrderDetailActivity;
import boss_android.transparent_factory.network.NetWork;
import boss_android.transparent_factory.network.ResponseCallback;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class ProcedureModelHelper {
    public static void getProcedureList(String orderId, final OrderDetailActivity callback) {
        NetWork.getService().requestProcedureList(orderId).enqueue(new ResponseCallback<ProcedureListResponse>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                ProcedureListResponse response = (ProcedureListResponse) data;
                if (response.getProcedures().isEmpty()) {
                    callback.onDataLoadFailed(OrderDetailActivity.TYPE_NO_PROCEDURE);
                } else {
                    callback.onDataLoadSuccess(response.getProcedures());
                }
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadFailed(OrderDetailActivity.TYPE_PROCEDURE_LOAD_ERROR);
            }
        }));
    }
}

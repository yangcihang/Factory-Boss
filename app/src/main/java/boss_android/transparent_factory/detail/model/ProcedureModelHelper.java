package boss_android.transparent_factory.detail.model;

import boss_android.transparent_factory.detail.OrderDetailActivity;
import boss_android.transparent_factory.detail.activity.ProcedureDetailActivity;
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

    public static void getProcedureNumList(String procedureId, final ProcedureDetailActivity callback) {
        NetWork.getService().requestProcedureNum(procedureId).enqueue(new ResponseCallback<ProcedureNumListResponse>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                ProcedureNumListResponse response = (ProcedureNumListResponse) data;
                if (response != null) {
                    callback.onDataLoadedSuccess(response);
                }

            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }
}

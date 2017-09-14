package boss_android.transparent_factory.mine.model;

import java.util.ArrayList;

import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.mine.MineFragment;
import boss_android.transparent_factory.mine.activity.AddEmployeeActivity;
import boss_android.transparent_factory.mine.activity.EmployeeAccountActivity;
import boss_android.transparent_factory.mine.activity.UserDetailActivity;
import boss_android.transparent_factory.network.NetWork;
import boss_android.transparent_factory.network.ResponseCallback;

/**
 * @author YangCihang
 * @since 17/9/2.
 * email yangcihang@hrsoft.net
 */

public class MineModelHelper {
    /**
     * 更新用户信息
     */
    public static void updateUserInfo(UserUpdateRequest requestBody, final UserDetailActivity callback) {
        NetWork.getService().updateUserInfo(String.valueOf(User.getId()), requestBody).enqueue(new ResponseCallback(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                callback.onDataLoadedSuccess();
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }

    public static void updatePassword(String password, final MineFragment callback) {
        PasswordModel model = new PasswordModel();
        model.setPassword(password);
        NetWork.getService().updateUserPassword(String.valueOf(User.getId()), model).enqueue(new ResponseCallback(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                callback.onDataLoadedSuccess();
            }

            @Override
            public void onDataFailed(int errorCode) {
                //失败时基类处理
            }
        }));
    }

    /**
     * 请求经理账号列表
     */
    public static void requestEmployeeList(final EmployeeAccountActivity callback) {
        NetWork.getService().requestEmployeeList().enqueue(new ResponseCallback<ArrayList<EmployeeModel>>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                ArrayList<EmployeeModel> list = (ArrayList<EmployeeModel>) data;
                callback.onDataLoadedSuccess(list);
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }

    /**
     * 更新经理信息
     */
    public static void updateEmployeeInfo(EmployeeUpdateRequest request, String id, final AddEmployeeActivity callback) {
        NetWork.getService().updateEmployeeInfo(String.valueOf(id), request).enqueue(new ResponseCallback(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                callback.onDataLoadedSuccess();
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }

    /**
     * 添加经理账号
     */
    public static void addEmployee(AddEmployeeRequest request, final AddEmployeeActivity callback) {
        NetWork.getService().addManagerInfo(request).enqueue(new ResponseCallback(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                callback.onDataLoadedSuccess();
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onDataLoadedFailed();
            }
        }));
    }
}

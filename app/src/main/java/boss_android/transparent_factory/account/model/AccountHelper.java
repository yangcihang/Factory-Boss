package boss_android.transparent_factory.account.model;

import boss_android.transparent_factory.account.activity.LoginActivity;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.network.NetWork;
import boss_android.transparent_factory.network.ResponseCallback;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class AccountHelper {
    /**
     * 登录
     */
    public static void login(final LoginRequest request, final LoginActivity callback) {
        NetWork.getService().login(request).enqueue(new ResponseCallback<LoginResponse>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                LoginResponse response = (LoginResponse) data;
                Account user = response.getUser();
                User.login(user, response.getToken());
                callback.onLoginSuccess();
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onLoginFailed();
            }
        }));
    }
}

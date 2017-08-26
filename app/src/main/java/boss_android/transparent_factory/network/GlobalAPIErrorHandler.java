package boss_android.transparent_factory.network;


import boss_android.transparent_factory.util.ToastUtil;

/**
 * 全局错误码统一处理
 *
 * @author YangCihang
 * @since 17/8/20.
 * email yangcihang@hrsoft.net
 */

public class GlobalAPIErrorHandler {
    public static void handle(int code) {
        switch (code) {
            //响应体错误码
            case RspCode.ERROR_ACCOUNT_TOKEN:
                ToastUtil.showToast("token过期，请重新登录", code);
                break;
            case RspCode.USER_NOT_EXIT:
                ToastUtil.showToast("用户不存在", code);
                break;
            case RspCode.PASSWORD_ERROR:
                ToastUtil.showToast("密码错误", code);
                break;

            //请求时http错误的状态码
            case HttpStateCode.INTERNAL_SERVER_ERROR:
                ToastUtil.showToast("服务器出错", code);
                break;
            default:
                ToastUtil.showToast("未知错误", code);
                break;
        }
    }
}

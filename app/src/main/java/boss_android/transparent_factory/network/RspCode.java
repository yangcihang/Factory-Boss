package boss_android.transparent_factory.network;

/**
 * 网络请求返回码
 *
 * @author: Vzer.
 * @date: 2017/7/25. 16:00
 * @email: vzer@qq.com
 */

public class RspCode {
    public static final int SUCCEED = 0;//成功
    public static final int ERROR_PARAMETERS = 4001;//参数错误
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;//用户已存在

    public static final int ERROR_SERVICE = 500;//服务器错误
    public static final int USER_NOT_EXIT = 30003;//用户不存在
    public static final int PASSWORD_ERROR = 30002;//密码错误
    public static final int ERROR_ACCOUNT_TOKEN = 20001;//用户token错误
    public static final int ERROR_ACCOUNT_LOGIN = 20004;//用户登录错误
    public static final int ERROR_ACCOUNT_REGISTER = 20003;//用户注册错误

    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;//用户无权限
}

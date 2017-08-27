package boss_android.transparent_factory.common;

/**
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public final class Config {
    /**
     * 验证手机号正则
     */
    public static final String MOBILE_REGEX = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    /**
     * 验证邮箱正则
     */
    public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * APP Server 网络请求BaseUrl
     */
    public static final String BASE_URL = "http://nuedc.hrsoft.net/api/";

    /**
     * APP Server 网络请求连接超时时间，单位：s
     */
    public static final int APP_SERVER_CONNECT_TIME_OUT = 15;

    /**
     * 启动页面到首页启动延时，单位：毫秒
     */
    public static final int SPLASH_GO_MAIN_DELAY = 1500;


}
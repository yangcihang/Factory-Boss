package boss_android.transparent_factory.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import boss_android.transparent_factory.App;

/**
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public class User {
    //private static
    private static final String KEY_PUSH_ID = "KEY_PUSH_ID";
    private static final String KEY_IS_BIND = "KEY_IS_BIND";
    private static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String KEY_MOBILE = "KEY_MOBILE";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_REAL_NAME = "KEY_REAL_NAME";
    private static final String KEY_SEX = "KEY_SEX";
    private static final String KEY_PORTRAIT = "KEY_PORTRAIT";
    private static final String KEY_UID = "KEY_UID";
    private static final String KEY_CREATEAT = "KEY_CREATE_AT";
    private static final String KEY_UPDATEDAT = "KEY_UPDATE_AT";


    private static String pushId;  // 设备的推送Id
    private static boolean isBind;// 设备Id是否已经绑定到了服务器
    private static String token; // 登录状态的Token，用来接口请求
    private static String mobile;// 登录的账户(手机号)
    private static int sex; //用户性别
    private static int uId; //用户id
    private static String name; // 用户昵称
    private static String realName; //真实姓名
    private static String portrait;//头像url
    private static long createAt; //创建时间
    private static long updatedAt;//更新时间

    /**
     * 存储数据到XML文件，持久化
     */
    private static void save(Context context) {
        //获取持久化数据的SP
        SharedPreferences sp = context.getSharedPreferences(User.class.getName(), Context.MODE_PRIVATE);
        //存储数据
        sp.edit()
                .putString(KEY_PUSH_ID, pushId)
                .putBoolean(KEY_IS_BIND, isBind)
                .putString(KEY_TOKEN, token)
                .putString(KEY_MOBILE, mobile)
                .putString(KEY_NAME, name)
                .putString(KEY_REAL_NAME, realName)
                .putInt(KEY_SEX, sex)
                .putString(KEY_PORTRAIT, portrait)
                .putInt(KEY_UID, uId)
                .putLong(KEY_CREATEAT, createAt)
                .putLong(KEY_UPDATEDAT, updatedAt)
                .apply();
    }

    /**
     * 进行数据加载
     */
    public static void load(Context context) {
        SharedPreferences sp = context.getSharedPreferences(User.class.getName(), Context.MODE_PRIVATE);
        pushId = sp.getString(KEY_PUSH_ID, "");
        isBind = sp.getBoolean(KEY_IS_BIND, false);
        token = sp.getString(KEY_TOKEN, "");
        mobile = sp.getString(KEY_MOBILE, "");
        name = sp.getString(KEY_NAME, "");
        realName = sp.getString(KEY_REAL_NAME, "");
        sex = sp.getInt(KEY_SEX, 1);
        portrait = sp.getString(KEY_PORTRAIT, "");
        uId = sp.getInt(KEY_UID, 0);
        createAt = sp.getLong(KEY_CREATEAT, 0);
        updatedAt = sp.getLong(KEY_UPDATEDAT, 0);
    }

    /**
     * 获取pushId
     */
    public static String getPushId() {
        return pushId;
    }

    /**
     * 设置pushId
     */
    public static void setPushId(String pushId) {
        User.pushId = pushId;
        User.save(App.getInstance());
    }

    /**
     * 设置头像uri
     */
    public static void setPortrait(String portrait) {
        User.portrait = portrait;
        User.save(App.getInstance());
    }

    /**
     * 是否已经绑定到服务器
     *
     * @return true 为已绑定
     */
    public static boolean isBind() {
        return isBind;
    }

    /**
     * 设置绑定状态
     */
    public static void setIsBind(boolean isBind) {
        User.isBind = isBind;
        User.save(App.getInstance());
    }

    /**
     * 登录信息持久化存储
     *
     * @param user
     */
    public static void login(User user) {
        User.token = user.getToken();
        User.mobile = user.getMobile();
        User.portrait = user.getPortrait();
        User.sex = user.getSex();
        User.name = user.getName();
        User.realName = user.getRealName();
        User.uId = user.getuId();
        User.
                save(App.getInstance());
    }

    /**
     * 返回当前用户是否登录了
     *
     * @return true已登录
     */
    public static boolean isLogin() {
        return !TextUtils.isEmpty(token)
                && !TextUtils.isEmpty(mobile);
    }

    /**
     * 退出登录清除数据
     */
    public static void exitLogin(Context context) {
        SharedPreferences sp = context.getSharedPreferences(User.class.getName(), Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }

    public static int getuId() {
        return uId;
    }

    public static String getMobile() {
        return mobile;
    }

    public static int getSex() {
        return sex;
    }

    public static String getName() {
        return name;
    }

    public static String getRealName() {
        return realName;
    }

    public static String getPortrait() {
        return portrait;
    }

    public static String getToken() {
        return token;
    }
}

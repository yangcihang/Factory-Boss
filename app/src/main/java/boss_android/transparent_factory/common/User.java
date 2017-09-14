package boss_android.transparent_factory.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import boss_android.transparent_factory.App;
import boss_android.transparent_factory.account.model.Account;

/**
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public class User {
    //private static
    private static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String KEY_MOBILE = "KEY_MOBILE";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_SEX = "KEY_SEX";
    private static final String KEY_PORTRAIT = "KEY_PORTRAIT";
    private static final String KEY_UID = "KEY_UID";
    private static final String KEY_CREATEAT = "KEY_CREATE_AT";
    private static final String KEY_UPDATEDAT = "KEY_UPDATE_AT";
    private static final String KEY_EMAIL = "KEY_EMAIL";


    private static String token = ""; // 登录状态的Token，用来接口请求
    private static String mobile;// 登录的账户(手机号)
    private static int sex; //用户性别
    private static int id; //用户id
    private static String name; // 用户昵称
    private static String email;//用户email

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
                .putString(KEY_TOKEN, token)
                .putString(KEY_MOBILE, mobile)
                .putString(KEY_NAME, name)
                .putInt(KEY_SEX, sex)
                .putString(KEY_PORTRAIT, portrait)
                .putInt(KEY_UID, id)
                .putLong(KEY_CREATEAT, createAt)
                .putLong(KEY_UPDATEDAT, updatedAt)
                .putString(KEY_EMAIL, email)
                .apply();
    }

    /**
     * 进行数据加载
     */
    public static void load(Context context) {
        SharedPreferences sp = context.getSharedPreferences(User.class.getName(), Context.MODE_PRIVATE);
        token = sp.getString(KEY_TOKEN, "");
        mobile = sp.getString(KEY_MOBILE, "");
        name = sp.getString(KEY_NAME, "");
        sex = sp.getInt(KEY_SEX, 1);
        portrait = sp.getString(KEY_PORTRAIT, "");
        id = sp.getInt(KEY_UID, 0);
        email = sp.getString(KEY_EMAIL, "");
        createAt = sp.getLong(KEY_CREATEAT, 0);
        updatedAt = sp.getLong(KEY_UPDATEDAT, 0);
    }


    /**
     * 登录信息持久化存储
     */
    public static void login(Account user, String token) {
        User.token = token;
        User.mobile = user.getMobile();
        User.name = user.getName();
        User.id = user.getId();
        User.email = user.getEmail();
        User.save(App.getInstance());
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
        //请空sp之前把静态量清除
        token = "";
        mobile = "";
        sp.edit().clear().apply();
    }

    /**
     * 设置头像uri
     */
    public static void setPortrait(String portrait) {
        User.portrait = portrait;
        User.save(App.getInstance());
    }

    public static void setMobile(String mobile) {
        User.mobile = mobile;
        User.save(App.getInstance());
    }

    public static void setName(String name) {
        User.name = name;
        User.save(App.getInstance());
    }

    public static int getId() {
        return id;
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


    public static String getPortrait() {
        return portrait;
    }

    public static String getToken() {
        return token;
    }

    public static String getEmail() {
        return email;
    }
}

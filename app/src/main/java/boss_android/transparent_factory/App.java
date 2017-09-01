package boss_android.transparent_factory;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.account.activity.LoginActivity;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.util.CacheUtil;

/**
 * Application类
 *
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public class App extends Application {
    private static App instance;//实例对象
    private static List<Activity> activityList = new ArrayList<>();
    private static CacheUtil cacheUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        User.load(this);
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        //RichText.initCacheDir(this);
    }

    /**
     * 缓存初始化
     */
    public CacheUtil getCacheUtil() {
        if (cacheUtil == null) {
            cacheUtil = CacheUtil.get(instance.getFilesDir());
        }
        return cacheUtil;
    }

    /**
     * 外部获取实例对象
     *
     * @return NUEDCApplication
     */
    public static App getInstance() {
        return instance;
    }

    private static android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new android.app.Application.ActivityLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activityList.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activityList.remove(activity);
        }
    };

    /**
     * 移除Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 清除所有Activity
     */
    public void removeAllActivity() {
        for (Activity activity : activityList) {
            if (activity != null && !activity.isFinishing())
                activity.finish();
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        removeAllActivity();
        // TODO: 17/8/25 退出的后续操作
    }

    /**
     * 退出账户
     */
    public void exitAccount() {
        User.exitLogin(this);
        removeAllActivity();
    }
}

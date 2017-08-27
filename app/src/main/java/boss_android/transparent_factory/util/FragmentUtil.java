package boss_android.transparent_factory.util;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import boss_android.transparent_factory.base.activity.BaseActivity;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class FragmentUtil {
    /**
     * 添加Fragment
     */
    public static void add(BaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment, tag)
                .commit();
    }

    /**
     * 替换Fragment
     */
    public static void replace(BaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    /**
     * 隐藏Fragment
     */
    public static void hideFragment(BaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .hide(fragment)
                .commit();
    }

    /**
     * 展示Fragment
     */
    public static void showFragment(BaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commit();
    }
}

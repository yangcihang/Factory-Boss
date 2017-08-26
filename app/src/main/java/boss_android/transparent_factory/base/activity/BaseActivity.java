package boss_android.transparent_factory.base.activity;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.common.LogicErrorException;
import boss_android.transparent_factory.util.Utility;
import butterknife.ButterKnife;

/**
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public abstract class BaseActivity extends AppCompatActivity {
    /** 进度窗 */
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 禁止APP横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 页面初始化操作.
     */
    protected void init() {
        ButterKnife.bind(this);
        preInit();
        initVariable();
        initView();
        loadData();
    }

    /**
     * 执行init 方法之前的处理
     */
    protected void preInit() {
        // progressDialog 统一定义
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    /**
     * 获取LayoutId.
     *
     * @return LayoutId 布局文件Id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化变量.
     */
    protected abstract void initVariable();

    /**
     * 初始化View的状态，挂载各种监听事件.
     */
    protected abstract void initView();

    /**
     * 初始化加载页面数据.
     */
    protected abstract void loadData();

    /**
     * 添加Fragment
     *
     * @param fragment fragment
     * @param bundle   传递的数据
     */
    protected void addFragment(@IdRes int containerViewId, BaseFragment fragment, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentTransaction.add(containerViewId, fragment).commit();
    }

    /**
     * 替换Fragment
     *
     * @param fragment fragment
     * @param bundle   传递的数据
     */
    protected void replaceFragment(@IdRes int containerViewId, BaseFragment fragment, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentTransaction.replace(containerViewId, fragment).addToBackStack(null).commit();
    }

    /**
     * 代码逻辑错误，在理论上不可达的位置调用此方法
     */
    protected void logicError() {
        try {
            throw new LogicErrorException();
        } catch (LogicErrorException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示progressDialog
     *
     * @param message 显示信息
     */
    protected void showProgressDialog(String message) {
        if (!isDestroyed() && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog.setMessage(message);
        Utility.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
            }
        });
    }

    /**
     * 显示progressDialog
     *
     * @param resId 显示信息资源ID
     */
    protected void showProgressDialog(@StringRes int resId) {
        String message = getString(resId);
        showProgressDialog(message);
    }

    /**
     * 取消ProgressDialog
     */
    protected void disMissProgressDialog() {
        if (!isDestroyed() && progressDialog.isShowing()) {
            Utility.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }

}
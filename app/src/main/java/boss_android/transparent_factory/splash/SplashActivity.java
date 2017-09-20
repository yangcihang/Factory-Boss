package boss_android.transparent_factory.splash;

import android.content.Intent;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.account.activity.LoginActivity;
import boss_android.transparent_factory.base.activity.NoBarActivity;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.main.MainActivity;
import boss_android.transparent_factory.util.Utility;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class SplashActivity extends NoBarActivity {
    private final static long SPLASH_TIME = 2000;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (User.isLogin()) {
            Utility.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, SPLASH_TIME);
        } else {
            Utility.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, SPLASH_TIME);
        }
    }
}

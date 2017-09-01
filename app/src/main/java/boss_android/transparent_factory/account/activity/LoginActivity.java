package boss_android.transparent_factory.account.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.account.model.AccountHelper;
import boss_android.transparent_factory.account.model.LoginRequest;
import boss_android.transparent_factory.base.activity.NoBarActivity;
import boss_android.transparent_factory.main.MainActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class LoginActivity extends NoBarActivity {
    @BindView(R.id.edit_account)
    EditText accountEdit;
    @BindView(R.id.edit_psw)
    EditText pswEdit;
    @BindView(R.id.btn_to_login)
    Button loginBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        accountEdit.addTextChangedListener(textWatcher);
        pswEdit.addTextChangedListener(textWatcher);
        loginBtn.setSelected(false);
    }

    @Override
    protected void loadData() {

    }

    /**
     * 点击登录
     */
    @OnClick(R.id.btn_to_login)
    void toLogin() {
        // TODO: 17/8/31 登录按钮状态显示
        String account = accountEdit.getText().toString().trim();
        String psw = pswEdit.getText().toString().trim();
        LoginRequest request = new LoginRequest(account, psw);
        showProgressDialog(R.string.dialog_loading);
        AccountHelper.login(request, this);
    }

    /**
     * 登录成功时
     */
    public void onLoginSuccess() {
        disMissProgressDialog();
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * 登录失败时
     */
    public void onLoginFailed() {
        disMissProgressDialog();
    }

    /**
     * 文字状态监听
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String account = accountEdit.getText().toString().trim();
            String psw = pswEdit.getText().toString().trim();
            if (account.length() > 10 && psw.length() > 6) {
                loginBtn.setSelected(true);
            } else {
                loginBtn.setSelected(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}

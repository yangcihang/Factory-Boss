package boss_android.transparent_factory.mine;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import boss_android.transparent_factory.App;
import boss_android.transparent_factory.R;
import boss_android.transparent_factory.account.activity.LoginActivity;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.mine.activity.EmployeeAccountActivity;
import boss_android.transparent_factory.mine.activity.UserDetailActivity;
import boss_android.transparent_factory.mine.model.MineModelHelper;
import boss_android.transparent_factory.util.DialogUtils;
import boss_android.transparent_factory.util.ToastUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class MineFragment extends BaseFragment {
    //    @BindView(R.id.rl_mine_change_mobile) RelativeLayout mineChangeMobileRl;
    @BindView(R.id.rl_mine_quit_account) RelativeLayout toAccount;
    @BindView(R.id.img_user_avatar) CircleImageView userAvatarImg;
    @BindView(R.id.txt_mine_user_name) TextView mineUserNameTxt;
    @BindView(R.id.txt_mine_user_account) TextView mineUserAccountTxt;
    @BindView(R.id.rl_mine_my_account) RelativeLayout mineMyAccountRl;
    @BindView(R.id.rl_mine_change_password) RelativeLayout mineChangePasswordRl;
    @BindView(R.id.rl_mine_employee_account) RelativeLayout mineEmployeeAccountRl;
    @BindView(R.id.txt_mine_quit_account) TextView mineQuitAccountTxt;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
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

    /**
     * 保证更改后能及时被修改
     */
    @Override
    public void onResume() {
        super.onResume();
        mineUserNameTxt.setText(User.getName());
        mineUserAccountTxt.setText(User.getMobile());
    }

    /**
     * 数据加载成功时回调
     */
    public void onDataLoadedSuccess() {
        ToastUtil.showToast(R.string.toast_user_updata_success);
    }

    /**
     * 跳转到登录页面
     */
    @OnClick(R.id.rl_mine_quit_account)
    void toAccount() {
        App.getInstance().exitAccount();
        startActivity(new Intent(getContext(), LoginActivity.class));
    }

    /**
     * 跳转到账号管理
     */
    @OnClick(R.id.rl_mine_employee_account)
    void toEmployeeAccount() {
        startActivity(new Intent(getContext(), EmployeeAccountActivity.class));
    }

    /**
     * 到用户详情页面
     */
    @OnClick(R.id.rl_mine_my_account)
    void toMyAccount() {
        startActivity(new Intent(getContext(), UserDetailActivity.class));
    }

    /**
     * 更换密码
     */
    @OnClick(R.id.rl_mine_change_password)
    void toChangePassword() {
        new DialogUtils(getContext())
                .setTitleText("修改密码")
                .setCancelable(false)
                .setInputEditView(InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .setNegativeButton(null)
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        String password = dialogUtils.getInputText();
                        if (password.length() < 6 || password.length() > 20) {
                            // TODO: 17/9/6 加入中文字符的判断
                            ToastUtil.showToast(R.string.toast_password_error);
                        } else {
                            MineModelHelper.updatePassword(password, MineFragment.this);
                        }
                    }
                })
                .showAlertDialog();
    }
}

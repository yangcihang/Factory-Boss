package boss_android.transparent_factory.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import boss_android.transparent_factory.App;
import boss_android.transparent_factory.R;
import boss_android.transparent_factory.account.activity.LoginActivity;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.mine.activity.EmployeeAccountActivity;
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
    @BindView(R.id.rl_mine_quit_account)
    RelativeLayout toAccount;
    @BindView(R.id.img_user_avatar) CircleImageView userAvatarImg;
    @BindView(R.id.txt_mine_user_name) TextView mineUserNameTxt;
    @BindView(R.id.txt_mine_user_account) TextView mineUserAccountTxt;
    @BindView(R.id.rl_mine_my_account) RelativeLayout mineMyAccountRl;
    @BindView(R.id.rl_mine_change_mobile) RelativeLayout mineChangeMobileRl;
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
}

package boss_android.transparent_factory.mine.activity;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.mine.model.MineModelHelper;
import boss_android.transparent_factory.mine.model.UserUpdateRequest;
import boss_android.transparent_factory.util.RegexUtil;
import boss_android.transparent_factory.util.ToastUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author YangCihang
 * @since 17/9/6.
 * email yangcihang@hrsoft.net
 */

public class UserDetailActivity extends ToolbarActivity {
    @BindView(R.id.edit_mine_user_name) EditText nameEdit;
    @BindView(R.id.edit_mine_user_mobile) EditText mobileEdit;
    @BindView(R.id.txt_mine_user_detail_confirm) TextView userDetailConfirmTxt;
    private String name;
    private String mobile;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_detail;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setActivityTitle("修改用户详情");
        nameEdit.setText(User.getName());
        mobileEdit.setText(User.getMobile());
    }

    @Override
    protected void loadData() {

    }

    /**
     * 点击确定后
     */
    @OnClick(R.id.txt_mine_user_detail_confirm)
    public void onViewClicked() {
        name = nameEdit.getText().toString().trim();
        mobile = mobileEdit.getText().toString().trim();
        if (name.equals(User.getName()) && mobile.equals(User.getMobile())) {
            this.finish();
            return;
        }
        if (!RegexUtil.checkMobile(mobile)) {
            ToastUtil.showToast(R.string.toast_mobile_error);
        } else if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast(R.string.toast_user_name_empty);
        } else {
            UserUpdateRequest request = new UserUpdateRequest();
            if (!mobile.equals(User.getMobile())) {
                request.setMobile(mobile);
            }
            request.setName(name);
            showProgressDialog(R.string.dialog_loading);
            MineModelHelper.updateUserInfo(request, this);
        }
    }

    /**
     * 数据加载成功时候
     */
    public void onDataLoadedSuccess() {
        disMissProgressDialog();
        ToastUtil.showToast(R.string.toast_user_updata_success);
        User.setMobile(mobile);
        User.setName(name);
        finish();
        int a[] = {1, 2, 3};
    }

    /**
     * 数据加载失败时
     */
    public void onDataLoadedFailed() {
        disMissProgressDialog();
    }
}

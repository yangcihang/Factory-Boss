package boss_android.transparent_factory.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.common.KeyValue;
import boss_android.transparent_factory.mine.model.AddEmployeeRequest;
import boss_android.transparent_factory.mine.model.EmployeeModel;
import boss_android.transparent_factory.mine.model.EmployeeUpdateRequest;
import boss_android.transparent_factory.mine.model.MineModelHelper;
import boss_android.transparent_factory.util.RegexUtil;
import boss_android.transparent_factory.util.ToastUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author YangCihang
 * @since 17/9/5.
 * email yangcihang@hrsoft.net
 */

public class AddEmployeeActivity extends ToolbarActivity {
    public static final int TYPE_ADD = 0x123;
    public static final int TYPE_CHANGE = 0x1234;
    @BindView(R.id.edit_mine_employee_name) EditText nameEdit;
    @BindView(R.id.edit_mine_employee_mobile) EditText mobileEdit;
    @BindView(R.id.edit_mine_employee_password) EditText passwordEdit;
    @BindView(R.id.txt_mine_user_detail_confirm) TextView confirmTxt;
    private int type;
    private EmployeeModel employeeModel;
    private String name;
    private String password;
    private String mobile;

    /**
     * 静态启动
     */
    public static void start(Context context, int type, EmployeeModel model) {
        Intent intent = new Intent(context, AddEmployeeActivity.class);
        intent.putExtra(KeyValue.KEY_EMPLOYEE_TYPE, type);
        if (model != null) {
            intent.putExtra(KeyValue.KEY_EMPLOYEE_MODEL, model);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_employee;
    }

    @Override
    protected void initVariable() {
        type = getIntent().getIntExtra(KeyValue.KEY_EMPLOYEE_TYPE, -1);
        employeeModel = (EmployeeModel) getIntent().getSerializableExtra(KeyValue.KEY_EMPLOYEE_MODEL);
    }

    @Override
    protected void initView() {
        switch (type) {
            case TYPE_ADD:
                setActivityTitle("添加经理账号");
                break;
            case TYPE_CHANGE:
                setActivityTitle("修改经理账号");
                nameEdit.setText(employeeModel.getName());
                mobileEdit.setText(employeeModel.getMobile());
//                passwordEdit.setHint("请输入经理的密码");
                break;
            default:
                logicError();
                break;
        }
    }

    @Override
    protected void loadData() {
    }

    @OnClick(R.id.txt_mine_user_detail_confirm)
    public void onViewClicked() {
        name = nameEdit.getText().toString().trim();
        mobile = mobileEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        switch (type) {
            case TYPE_ADD:
                addEmployeeAccount();
                break;
            case TYPE_CHANGE:
                changeEmployeeAccount();
                break;
        }

    }

    /**
     * 添加经理账号
     */
    private void addEmployeeAccount() {
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast(R.string.toast_user_name_empty);
        } else if (!RegexUtil.checkMobile(mobile)) {
            ToastUtil.showToast(R.string.toast_mobile_error);
        } else if (password.length() < 6 || password.length() > 20) {
            ToastUtil.showToast(R.string.toast_password_error);
        } else {
            EmployeeModel model = new EmployeeModel();
            model.setMobile(mobile);
            model.setPassword(password);
            model.setName(name);
            List<EmployeeModel> employeeModel = new ArrayList<>();
            employeeModel.add(model);
            AddEmployeeRequest request = new AddEmployeeRequest();
            request.setManagers(employeeModel);
            MineModelHelper.addEmployee(request, this);
        }
    }

    /**
     * 更新经理账号信息
     */
    private void changeEmployeeAccount() {
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast(R.string.toast_user_name_empty);
        } else if (!RegexUtil.checkMobile(mobile)) {
            ToastUtil.showToast(R.string.toast_mobile_error);
        } else if (password.length() < 6 || password.length() > 20) {
            ToastUtil.showToast(R.string.toast_password_error);
        } else {
            EmployeeUpdateRequest model = new EmployeeUpdateRequest();
            if (!mobile.equals(employeeModel.getMobile())) {
                model.setMobile(mobile);
            }
            model.setPassword(password);
            model.setName(name);
            MineModelHelper.updateEmployeeInfo(model, String.valueOf(employeeModel.getId()), this);
        }
    }

    /**
     * 数据加载成功时
     */
    public void onDataLoadedSuccess() {
        ToastUtil.showToast(R.string.toast_user_updata_success);
        this.finish();
    }

    /**
     * 数据加载失败时
     */
    public void onDataLoadedFailed() {

    }
}

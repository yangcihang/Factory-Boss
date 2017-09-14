package boss_android.transparent_factory.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.mine.adapter.EmployeeAdapter;
import boss_android.transparent_factory.mine.model.EmployeeModel;
import boss_android.transparent_factory.mine.model.MineModelHelper;
import boss_android.transparent_factory.widget.SimpleRecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class EmployeeAccountActivity extends ToolbarActivity {
    @BindView(R.id.rec_mine_employee_account)
    SimpleRecyclerView employeeAccountRec;
    @BindView(R.id.empty)
    View empty;
    private EmployeeAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_employee_account;
    }

    @Override
    protected void initVariable() {
        adapter = new EmployeeAdapter(this);
        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClicked<EmployeeModel>() {
            @Override
            public void onItemClicked(EmployeeModel model, RecyclerViewAdapter.ViewHolder holder) {
                AddEmployeeActivity.start(EmployeeAccountActivity.this, AddEmployeeActivity.TYPE_CHANGE, model);
            }
        });
    }

    @Override
    protected void initView() {
        setActivityTitle("经理账号管理");
        employeeAccountRec.setAdapter(adapter);
        employeeAccountRec.setLayoutManager(new LinearLayoutManager(this));
        employeeAccountRec.setEmptyView(empty);
    }

    @Override
    protected void loadData() {
    }

    /**
     * 重写此方法，保证回下一次返回时及时更新
     */
    @Override
    protected void onResume() {
        super.onResume();
        showProgressDialog(R.string.dialog_loading);
        MineModelHelper.requestEmployeeList(this);
    }

    /**
     * 加载经理账号成功时
     */
    public void onDataLoadedSuccess(List<EmployeeModel> models) {
        disMissProgressDialog();
        adapter.setData(models);
    }

    /**
     * 加载经理账号失败时
     */
    public void onDataLoadedFailed() {
        disMissProgressDialog();
    }

    @OnClick(R.id.fab_add_employee)
    void onAddEmployee() {
        AddEmployeeActivity.start(this, AddEmployeeActivity.TYPE_ADD, null);
    }


}

package boss_android.transparent_factory.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.mine.adapter.EmployeeAdapter;
import boss_android.transparent_factory.mine.model.EmployeeModel;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class EmployeeAccountActivity extends ToolbarActivity {
    @BindView(R.id.rec_mine_employee_account)
    RecyclerView employeeAccountRec;
    @BindView(R.id.txt_mine_employee_add)
    TextView employeeAddTxt;
    private EmployeeAdapter adapter;
    private RecyclerScrollListener scrollListener;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_employee_account;
    }

    @Override
    protected void initVariable() {
        adapter = new EmployeeAdapter(this);
        scrollListener = new RecyclerScrollListener();
        initListVariable();
    }

    @Override
    protected void initView() {
        employeeAccountRec.setAdapter(adapter);
        employeeAccountRec.setLayoutManager(new LinearLayoutManager(this));
        employeeAccountRec.setOnScrollListener(scrollListener);
    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.txt_mine_employee_add)
    public void onViewClicked() {

    }

    /**
     * 初始化列表变量
     */
    private void initListVariable() {
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {

            }
        });
        adapter.setOnItemClickedListener(new RecyclerFooterAdapter.OnItemClicked<EmployeeModel>() {
            @Override
            public void onItemClicked(EmployeeModel employeeModel, RecyclerFooterAdapter.ViewHolder holder) {

            }
        });
    }

}

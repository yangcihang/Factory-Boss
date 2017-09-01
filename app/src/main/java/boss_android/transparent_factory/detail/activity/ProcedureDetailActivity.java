package boss_android.transparent_factory.detail.activity;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class ProcedureDetailActivity extends ToolbarActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_procedure_detail;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setActivityTitle("工序详情");
    }

    @Override
    protected void loadData() {

    }
}

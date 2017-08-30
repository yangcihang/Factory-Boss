package boss_android.transparent_factory.detail;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;

/**
 * @author YangCihang
 * @since 17/8/30.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailActivity extends ToolbarActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        setActivityTitle("订单详情");
    }

    @Override
    protected void loadData() {

    }
}

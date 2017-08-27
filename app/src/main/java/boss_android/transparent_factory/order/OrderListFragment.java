package boss_android.transparent_factory.order;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.order.adapter.OrderVpAdapter;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class OrderListFragment extends BaseFragment {
    @BindView(R.id.tab_order_list)
    TabLayout orderTab;
    @BindView(R.id.vp_order_list)
    ViewPager orderVp;
    private OrderVpAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_list;
    }

    @Override
    protected void initVariable() {
        adapter = new OrderVpAdapter(getActivity().getSupportFragmentManager());
    }

    @Override
    protected void initView() {
        orderVp.setAdapter(adapter);
        orderTab.setupWithViewPager(orderVp);
    }

    @Override
    protected void loadData() {
    }
}

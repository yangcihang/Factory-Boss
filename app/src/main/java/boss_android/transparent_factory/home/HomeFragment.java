package boss_android.transparent_factory.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.home.adapter.HomeVpAdapter;
import butterknife.BindView;

/**
 * 进入首页的展示
 *
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.vp_order_home)
    ViewPager homeVp;
    @BindView(R.id.tab_order_capacity)
    TabLayout capacityTab;
    private HomeVpAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initVariable() {
        adapter = new HomeVpAdapter(getActivity().getSupportFragmentManager());
    }

    @Override
    protected void initView() {
        homeVp.setAdapter(adapter);
        capacityTab.setupWithViewPager(homeVp);
    }

    @Override
    protected void loadData() {

    }
}

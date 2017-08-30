package boss_android.transparent_factory.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import boss_android.transparent_factory.App;
import boss_android.transparent_factory.R;
import boss_android.transparent_factory.home.fragment.ChartFragment;
import boss_android.transparent_factory.home.fragment.DataFragment;
import boss_android.transparent_factory.order.fragment.OrderListContentFragment;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class HomeVpAdapter extends FragmentPagerAdapter {
    private final static int PAGER_SUM = 2;
    private final static int PAGER_CHART = 0;
    private final static int PAGER_DATA = 1;
    private ChartFragment chartFragment;
    private DataFragment dataFragment;

    public HomeVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case PAGER_CHART:
                if (chartFragment == null) {
                    chartFragment = new ChartFragment();
                }
                fragment = chartFragment;
                break;
            case PAGER_DATA:
                if (dataFragment == null) {
                    dataFragment = new DataFragment();
                }
                fragment = dataFragment;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_SUM;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case PAGER_CHART:
                title = App.getInstance().getString(R.string.title_home_chart);
                break;
            case PAGER_DATA:
                title = App.getInstance().getString(R.string.title_home_data);
                break;
        }
        return title;
    }
}

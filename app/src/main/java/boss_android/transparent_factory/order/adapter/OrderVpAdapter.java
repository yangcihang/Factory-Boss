package boss_android.transparent_factory.order.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import boss_android.transparent_factory.App;
import boss_android.transparent_factory.R;
import boss_android.transparent_factory.order.fragment.OrderListContentFragment;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class OrderVpAdapter extends FragmentPagerAdapter {
    private final static int FRAGMENT_COUNT = 3;
    private OrderListContentFragment processingOrderListContentFragment;
    private OrderListContentFragment finishedOrderListContentFragment;
    private OrderListContentFragment unstartOrderListContentFragment;

    public OrderVpAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case OrderListContentFragment.TYPE_PROCESSING:
                if (processingOrderListContentFragment == null) {
                    processingOrderListContentFragment = new OrderListContentFragment(OrderListContentFragment.TYPE_PROCESSING);
                }
                fragment = processingOrderListContentFragment;
                break;
            case OrderListContentFragment.TYPE_FINISHED:
                if (finishedOrderListContentFragment == null) {
                    finishedOrderListContentFragment = new OrderListContentFragment(OrderListContentFragment.TYPE_FINISHED);
                }
                fragment = finishedOrderListContentFragment;
                break;
            case OrderListContentFragment.TYPE_UNSTART:
                if (unstartOrderListContentFragment == null) {
                    unstartOrderListContentFragment = new OrderListContentFragment(OrderListContentFragment.TYPE_UNSTART);
                }
                fragment = unstartOrderListContentFragment;
                break;
            default:
                break;
        }
        return fragment;
    }

    /**
     * 不做销毁处理
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case OrderListContentFragment.TYPE_PROCESSING:
                title = App.getInstance().getString(R.string.title_order_processing);
                break;
            case OrderListContentFragment.TYPE_FINISHED:
                title = App.getInstance().getString(R.string.title_order_finished);
                break;
            case OrderListContentFragment.TYPE_UNSTART:
                title = App.getInstance().getString(R.string.title_order_unstart);
                break;
            default:
                break;
        }
        return title;
    }
}

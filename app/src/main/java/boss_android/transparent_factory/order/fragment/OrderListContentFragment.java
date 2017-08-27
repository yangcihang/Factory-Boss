package boss_android.transparent_factory.order.fragment;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.order.adapter.OrderListAdapter;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

@SuppressLint("ValidFragment")
public class OrderListContentFragment extends BaseFragment {
    @BindView(R.id.refresh_order_list)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.rec_order_list)
    RecyclerView listRec;
    private OrderListAdapter adapter;
    private RecyclerScrollListener scrollListener;
    public static final int TYPE_PROCESSING = 0;
    public static final int TYPE_FINISHED = 1;
    public static final int TYPE_UNSTART = 2;
    private int type;

    public OrderListContentFragment(int type) {
        this.type = type;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_list_content;
    }

    @Override
    protected void initVariable() {
        adapter = new OrderListAdapter(getContext());
        scrollListener = new RecyclerScrollListener();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }
}

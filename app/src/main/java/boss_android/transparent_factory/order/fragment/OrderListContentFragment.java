package boss_android.transparent_factory.order.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.common.KeyValue;
import boss_android.transparent_factory.detail.OrderDetailActivity;
import boss_android.transparent_factory.order.adapter.OrderListAdapter;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.util.ToastUtil;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

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
    private int type; //页面类型（进行 中，已完成，未开始）

    /**
     * 返回Fragment的实例
     */
    public static OrderListContentFragment createFragment(int type) {
        OrderListContentFragment fragment = new OrderListContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KeyValue.KEY_ORDER_FRAGMENT_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_list_content;
    }

    @Override
    protected void initVariable() {
        adapter = new OrderListAdapter(getContext());
        scrollListener = new RecyclerScrollListener();
        adapter.setOnItemClickedListener(new RecyclerFooterAdapter.OnItemClicked<OrderListModel>() {
            @Override
            public void onItemClicked(OrderListModel orderListModel, RecyclerFooterAdapter.ViewHolder holder) {
                startActivity(new Intent(getContext(), OrderDetailActivity.class));
            }
        });
    }

    @Override
    protected void initView() {
        type = getArguments().getInt(KeyValue.KEY_ORDER_FRAGMENT_TYPE);
        listRec.setAdapter(adapter);
        listRec.setLayoutManager(new LinearLayoutManager(getContext()));
        listRec.setOnScrollListener(scrollListener);
    }

    @Override
    protected void loadData() {
        List<OrderListModel> lists = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lists.add(new OrderListModel());
        }
        adapter.setData(lists);
    }
}

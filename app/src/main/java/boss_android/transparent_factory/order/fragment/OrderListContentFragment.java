package boss_android.transparent_factory.order.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.common.KeyValue;
import boss_android.transparent_factory.common.LogicErrorException;
import boss_android.transparent_factory.detail.OrderDetailActivity;
import boss_android.transparent_factory.order.adapter.OrderListAdapter;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.order.model.OrderListModelHelper;
import boss_android.transparent_factory.widget.SimpleRecyclerView;
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
    SimpleRecyclerView listRec;
    @BindView(R.id.empty)
    View emptyView;
    private OrderListAdapter adapter;
    private RecyclerScrollListener scrollListener;
    public static final int TYPE_PROCESSING = 0;
    public static final int TYPE_FINISHED = 1;
    public static final int TYPE_UNSTART = 2;
    private int page = 1;
    private final static int size = 8;//默认一页8个
    private boolean isFirstLoad = true; //是否从第一页开始加载
    private boolean isLastPage = false;//是不是最后一页
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
        initListVariable();
    }

    @Override
    protected void initView() {
        type = getArguments().getInt(KeyValue.KEY_ORDER_FRAGMENT_TYPE);
        listRec.setAdapter(adapter);
        listRec.setEmptyView(emptyView);
        listRec.setLayoutManager(new LinearLayoutManager(getContext()));
        listRec.setOnScrollListener(scrollListener);
    }

    @Override
    protected void loadData() {
        getDataSource();
    }

    /**
     * 发起获取数据源的请求
     */
    private void getDataSource() {
        String p = String.valueOf(page);
        String s = String.valueOf(size);
        switch (type) {
            case TYPE_PROCESSING:
                OrderListModelHelper.requestProcessingData(p, s, this);
                break;
            case TYPE_UNSTART:
                OrderListModelHelper.requestUnstartData(p, s, this);
                break;
            case TYPE_FINISHED:
                OrderListModelHelper.requestFinishedData(p, s, this);
                break;
            default:
                try {
                    throw new LogicErrorException();
                } catch (LogicErrorException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    /**
     * 数据成功返回时
     */
    public void onDataLoadedSuccess(List<OrderListModel> models, int pageSum) {
        page += 1;
        if (isFirstLoad) {
            isFirstLoad = false;
            adapter.setData(models);
        } else {
            adapter.addAll(models);
        }
        if (adapter.getListData().size() == pageSum) {
            isLastPage = true;
        }
        swipeRefresh.setRefreshing(false);
        adapter.setToRefresh(false);
    }

    /**
     * 数据返回失败时候
     */
    public void onDataLoadedFailed() {
        adapter.setToRefresh(false);
        swipeRefresh.setRefreshing(false);
    }

    /**
     * 初始化列表变量
     */
    private void initListVariable() {
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {
                if (!swipeRefresh.isRefreshing()) {
                    if (!isLastPage) {
                        adapter.setToRefresh(true);
                        getDataSource();
                    } else {
                        adapter.setToRefresh(false);
                    }
                }
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                isLastPage = false;
                isFirstLoad = true;
                getDataSource();
            }
        });
        adapter.setOnItemClickedListener(new RecyclerFooterAdapter.OnItemClicked<OrderListModel>() {
            @Override
            public void onItemClicked(OrderListModel orderListModel, RecyclerFooterAdapter.ViewHolder holder) {
                OrderDetailActivity.start(getContext(), orderListModel);
            }
        });
    }
}

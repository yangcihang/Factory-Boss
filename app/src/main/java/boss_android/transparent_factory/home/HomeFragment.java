package boss_android.transparent_factory.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.detail.OrderDetailActivity;
import boss_android.transparent_factory.home.adapter.HomeChartAdapter;
import boss_android.transparent_factory.home.model.HomeListModelHelper;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.widget.SimpleRecyclerView;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.rec_home_chart)
    SimpleRecyclerView chartRec;
    @BindView(R.id.refresh_home_chart)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.empty)
    View emptyView;
    private HomeChartAdapter adapter;
    private RecyclerScrollListener scrollListener;
    private int page = 1;
    private final static int size = 8;//默认一页8个
    private boolean isFirstLoad = true; //是否从第一页开始加载
    private boolean isLastPage = false;//是不是最后一页

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_chart;
    }

    /**
     * 初始化变量
     */
    @Override
    protected void initVariable() {
        adapter = new HomeChartAdapter(getContext());
        scrollListener = new RecyclerScrollListener();
        initListVariable();
    }

    @Override
    protected void initView() {
        chartRec.setAdapter(adapter);
        chartRec.setLayoutManager(new LinearLayoutManager(getContext()));
        chartRec.setOnScrollListener(scrollListener);
        chartRec.setEmptyView(emptyView);
    }

    /**
     * 加载首页数据
     */
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
        HomeListModelHelper.requestProcessingData(p, s, this);
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
     * 初始化列表的变量
     */
    private void initListVariable() {
        adapter.setOnItemClickedListener(new RecyclerFooterAdapter.OnItemClicked<OrderListModel>() {
            @Override
            public void onItemClicked(OrderListModel homeChartModel, RecyclerFooterAdapter.ViewHolder holder) {
                OrderDetailActivity.start(getContext(), homeChartModel);
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
    }

}

package boss_android.transparent_factory.home.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.home.adapter.HomeChartAdapter;
import boss_android.transparent_factory.home.model.HomeChartModel;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class ChartFragment extends BaseFragment {
    @BindView(R.id.rec_home_chart)
    RecyclerView chartRec;
    @BindView(R.id.refresh_home_chart)
    SwipeRefreshLayout chartRefresh;
    private HomeChartAdapter adapter;
    private RecyclerScrollListener scrollListener;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_chart;
    }

    @Override
    protected void initVariable() {
        adapter = new HomeChartAdapter(getContext());
        scrollListener = new RecyclerScrollListener();
    }

    @Override
    protected void initView() {
        chartRec.setAdapter(adapter);
        chartRec.setLayoutManager(new LinearLayoutManager(getContext()));
        chartRec.setOnScrollListener(scrollListener);
        chartRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {

            }
        });
    }

    @Override
    protected void loadData() {
        List<HomeChartModel> list = new ArrayList<>();
        list.add(new HomeChartModel());
        list.add(new HomeChartModel());
        list.add(new HomeChartModel());
        adapter.setData(list);


    }
}

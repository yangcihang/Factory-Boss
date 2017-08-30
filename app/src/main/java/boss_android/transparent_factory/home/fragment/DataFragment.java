package boss_android.transparent_factory.home.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerScrollListener;
import boss_android.transparent_factory.base.fragment.BaseFragment;
import boss_android.transparent_factory.home.adapter.HomeDataAdapter;
import boss_android.transparent_factory.home.model.HomeDataModel;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class DataFragment extends BaseFragment {
    @BindView(R.id.rec_home_data)
    RecyclerView dataRec;
    @BindView(R.id.refresh_home_data)
    SwipeRefreshLayout refreshLayout;
    private HomeDataAdapter adapter;
    private RecyclerScrollListener scrollListener;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_data;
    }

    @Override
    protected void initVariable() {
        adapter = new HomeDataAdapter(getContext());
        scrollListener = new RecyclerScrollListener();
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {

            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    @Override
    protected void initView() {
        dataRec.setAdapter(adapter);
        dataRec.setOnScrollListener(scrollListener);
        dataRec.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void loadData() {
        List<HomeDataModel> list = new ArrayList<>();
        list.add(new HomeDataModel());
        list.add(new HomeDataModel());
        list.add(new HomeDataModel());
        adapter.setData(list);
    }
}

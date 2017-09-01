package boss_android.transparent_factory.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.common.KeyValue;
import boss_android.transparent_factory.detail.activity.ProcedureDetailActivity;
import boss_android.transparent_factory.detail.adapter.DetailProcedureAdapter;
import boss_android.transparent_factory.detail.model.ProcedureModel;
import boss_android.transparent_factory.detail.model.ProcedureModelHelper;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.util.ToastUtil;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/30.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailActivity extends ToolbarActivity {
    @BindView(R.id.rec_detail_procedure)
    RecyclerView procedureRec;
    @BindView(R.id.txt_detail_order_custom)
    TextView detailOrderCustomTxt;
    @BindView(R.id.txt_detail_order_id)
    TextView detailOrderIdTxt;
    @BindView(R.id.txt_detail_order_title)
    TextView detailOrderTitleTxt;
    @BindView(R.id.txt_detail_center_title)
    TextView detailCenterTitleTxt;
    @BindView(R.id.txt_detail_order_create_time)
    TextView orderCreateTimeTxt;
    @BindView(R.id.txt_detail_order_end_time)
    TextView orderEndTimeTxt;
    @BindView(R.id.chart_pie_detail_order_total_completion)
    PieChart orderTotalCompletionPieChart;
    private DetailProcedureAdapter adapter;
    private OrderListModel contentModel;
    public static final int TYPE_NO_PROCEDURE = 1;
    public static final int TYPE_PROCEDURE_LOAD_ERROR = 2;

    /**
     * 静态启动
     */
    public static void start(Context context, OrderListModel orderListModel) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(KeyValue.KEY_ORDER_LIST_MODEL, orderListModel);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initVariable() {
        adapter = new DetailProcedureAdapter(this);
        contentModel = (OrderListModel) getIntent().getSerializableExtra(KeyValue.KEY_ORDER_LIST_MODEL);
        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClicked<ProcedureModel>() {
            @Override
            public void onItemClicked(ProcedureModel procedureModel, RecyclerViewAdapter.ViewHolder holder) {
                startActivity(new Intent(OrderDetailActivity.this, ProcedureDetailActivity.class));
            }
        });
    }

    @Override
    protected void initView() {
        setActivityTitle("订单详情");
        procedureRec.setLayoutManager(new LinearLayoutManager(this));
        procedureRec.setAdapter(adapter);
        if (contentModel != null) {
            detailOrderCustomTxt.setText(contentModel.getCustomerInfo());
            detailOrderIdTxt.setText(contentModel.getOrderCode());
            orderEndTimeTxt.setText(contentModel.getEndTime());
            orderCreateTimeTxt.setText(contentModel.getStartTime());
            detailOrderTitleTxt.setText(contentModel.getTitle());
        }
    }

    @Override
    protected void loadData() {
        showProgressDialog(R.string.dialog_loading);
        if (contentModel != null) {
            ProcedureModelHelper.getProcedureList(String.valueOf(contentModel.getId()), this);
        } else {
            onDataLoadFailed(TYPE_PROCEDURE_LOAD_ERROR);
        }
    }

    /**
     * 数据返回成功时候
     */
    public void onDataLoadSuccess(List<ProcedureModel> procedureModels) {
        disMissProgressDialog();
        adapter.setData(procedureModels);
    }

    /**
     * 数据返回失败时候
     */
    public void onDataLoadFailed(int type) {
        disMissProgressDialog();
        if (type == TYPE_PROCEDURE_LOAD_ERROR) {
            ToastUtil.showToast(R.string.toast_procedure_load_failed);
        } else {
            ToastUtil.showToast(R.string.toast_no_procedure_info);
        }
    }
}

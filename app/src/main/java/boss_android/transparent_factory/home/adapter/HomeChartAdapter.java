package boss_android.transparent_factory.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.util.TimeUtil;
import boss_android.transparent_factory.util.chart.PieChartUtils;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class HomeChartAdapter extends RecyclerFooterAdapter<OrderListModel> {


    public HomeChartAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_ITEM) {
            View view = inflater.inflate(R.layout.item_rec_home_chart, parent, false);
            return new ItemHolder(view);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    class ItemHolder extends ViewHolder<OrderListModel> {
        @BindView(R.id.txt_home_order_create_time)
        TextView createTimeTxt;
        @BindView(R.id.txt_home_order_end_time)
        TextView endTimeTxt;
        @BindView(R.id.txt_home_order_title)
        TextView titleTxt;
        @BindView(R.id.txt_home_order_custom_info)
        TextView customTxt;
        @BindView(R.id.txt_home_order_id)
        TextView orderIdTxt;
        @BindView(R.id.chart_pie_home_order_total_completion)
        PieChart totalCompletionPieChart;
        @BindView(R.id.chart_pie_home_order_time_completion)
        PieChart timeCompletionPieChart;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderListModel orderListModel, int position) {
            createTimeTxt.setText(orderListModel.getCreatedAt());
            endTimeTxt.setText(orderListModel.getEndTime());
            customTxt.setText(orderListModel.getCustomerInfo());
            titleTxt.setText(orderListModel.getTitle());
            orderIdTxt.setText(orderListModel.getOrderCode());
            float createTime = TimeUtil.setStringToStamp(orderListModel.getStartTime());
            float endTime = TimeUtil.setStringToStamp(orderListModel.getEndTime());
            float currentTime = TimeUtil.getCurrentTimeStamp();
            float timePercent = ((currentTime - createTime) / (endTime - createTime)) * 100;
            initChart();
            initCapacityChartValue(orderListModel);
            initTimeChartValue(timePercent);
        }

        private void initChart() {
            PieChartUtils.initPieChart(totalCompletionPieChart);
            PieChartUtils.initPieChart(timeCompletionPieChart);
        }

        private void initCapacityChartValue(OrderListModel orderListModel) {
            List<PieEntry> totalEntries = new ArrayList<>();
            float capacity = orderListModel.getCapacity();
            totalEntries.add(new PieEntry(capacity * 100, "产能完成度"));
            totalEntries.add(new PieEntry(100 - capacity * 100, "产能未完成度"));
            PieDataSet totalSet = new PieDataSet(totalEntries, "");
            ArrayList<Integer> colors = new ArrayList<>();
            colors.add(Color.rgb(207, 180, 105));
            colors.add(Color.rgb(33, 33, 33));
            totalSet.setColors(colors);
            totalSet.setValueTextSize(12);
            totalSet.setValueTextColor(Color.WHITE);
            PieData pieData = new PieData(totalSet);
            totalCompletionPieChart.setData(pieData);
            totalCompletionPieChart.invalidate();

        }

        private void initTimeChartValue(float timePercent) {
            List<PieEntry> timeEntries = new ArrayList<>();
            timeEntries.add(new PieEntry(timePercent, "当前时间进度"));
            timeEntries.add(new PieEntry(100 - timePercent, "剩余时间进度"));
            PieDataSet timeSet = new PieDataSet(timeEntries, "");
            ArrayList<Integer> colors = new ArrayList<>();
            colors.add(Color.rgb(207, 180, 105));
            colors.add(Color.rgb(33, 33, 33));
            timeSet.setValueTextSize(12);
            timeSet.setValueTextColor(Color.WHITE);
            timeSet.setColors(colors);
            PieData pieData = new PieData(timeSet);
            timeCompletionPieChart.setData(pieData);
            timeCompletionPieChart.invalidate();
        }
    }
}

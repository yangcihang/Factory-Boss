package boss_android.transparent_factory.detail.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.ToolbarActivity;
import boss_android.transparent_factory.common.KeyValue;
import boss_android.transparent_factory.detail.adapter.DetailProcedureListAdapter;
import boss_android.transparent_factory.detail.model.ProcedureModel;
import boss_android.transparent_factory.detail.model.ProcedureModelHelper;
import boss_android.transparent_factory.detail.model.ProcedureNumListResponse;
import boss_android.transparent_factory.detail.model.ProcedureNumModel;
import boss_android.transparent_factory.util.TimeUtil;
import butterknife.BindView;

/**
 * 工序详情页
 *
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class ProcedureDetailActivity extends ToolbarActivity {
    @BindView(R.id.txt_detail_procedure_class_title) TextView classTitleTxt;
    @BindView(R.id.txt_detail_procedure_id) TextView procedureIdTxt;
    @BindView(R.id.txt_detail_procedure_title) TextView procedureTitleTxt;
    @BindView(R.id.txt_detail_procedure_quality_percent) TextView qualityPercentTxt;
    @BindView(R.id.progress_detail_procedure) ProgressBar procedureProgress;
    @BindView(R.id.txt_detail_procedure_quality_ratio) TextView qualityRatioTxt;
    @BindView(R.id.line_chart_detail_procedure) LineChart lineChart;
    @BindView(R.id.rec_detail_procedure_list) RecyclerView procedureListRec;
    private ProcedureModel procedureModel;
    private DetailProcedureListAdapter adapter;

    /**
     * 静态启动
     */
    public static void start(Context context, ProcedureModel procedureModel) {
        Intent intent = new Intent(context, ProcedureDetailActivity.class);
        intent.putExtra(KeyValue.KEY_PROCEDURE_DETAIL, procedureModel);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_procedure_detail;
    }

    @Override
    protected void initVariable() {
        procedureModel = (ProcedureModel) getIntent().getSerializableExtra(KeyValue.KEY_PROCEDURE_DETAIL);
    }

    @Override
    protected void initView() {
        setActivityTitle("工序详情");
        float successNum = procedureModel.getSuccessCount();
        float totalNum = procedureModel.getTotalCount();
        int percent = (int) ((successNum / totalNum) * 100);
        if (procedureModel != null) {
            classTitleTxt.setText(procedureModel.getWorkGroupName());
            procedureIdTxt.setText("任务号:" + String.valueOf(procedureModel.getId()));
            procedureTitleTxt.setText(procedureModel.getName());
            qualityPercentTxt.setText("合格率" + String.valueOf(percent) + "%");
            procedureProgress.setProgress(percent);
            qualityRatioTxt.setText(String.valueOf((int) successNum) + "/" + String.valueOf((int) totalNum));
        }
        initList();
    }

    @Override
    protected void loadData() {
        showProgressDialog(R.string.dialog_loading);
        ProcedureModelHelper.getProcedureNumList(String.valueOf(procedureModel.getId()), this);
    }

    /**
     * 初始化list
     */
    private void initList() {
        adapter = new DetailProcedureListAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        procedureListRec.setAdapter(adapter);
        procedureListRec.setLayoutManager(layoutManager);
        procedureListRec.setNestedScrollingEnabled(false);
        procedureListRec.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        procedureListRec.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    /**
     * 初始化图表
     */
    private void initChart(ProcedureNumListResponse response) {
        if (!response.getLogs().isEmpty()) {
            Map<Long, Integer> chartModelMap = formatValue(response.getLogs()); //获取chart的model
            int xSumCount = 0;//x轴的计数分布
            int maxValue = 0;//y轴最大值(在数据项为1时使用)
            final List<String> xValue = new ArrayList<>();//x轴值
            List<Entry> lineEntries = new ArrayList<>();
            XAxis xAxis = lineChart.getXAxis();
            YAxis yAxis = lineChart.getAxisLeft();
            for (Object o : chartModelMap.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                Long key = (Long) entry.getKey();
                Integer value = (Integer) entry.getValue();
                lineEntries.add(new Entry(xSumCount++, value));
                xValue.add(TimeUtil.setStampToString(key, TimeUtil.TIME_DEFAULT_MONTH));
                if (value > maxValue) {
                    maxValue = value;
                    if (chartModelMap.size() == 1)
                        yAxis.setAxisMaximum(maxValue * 2);
                }
            }
            LineDataSet dataSet = new LineDataSet(lineEntries, "产能进度");
            dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            dataSet.setColors(Color.rgb(207, 180, 105));
            LineData lineData = new LineData(dataSet);
            lineData.setValueTextSize(12);

            yAxis.setAxisMinimum(0f);
            xAxis.setAxisMinimum(-1f);
            xAxis.setAxisMaximum(chartModelMap.size() + 1);
            xAxis.setLabelCount(chartModelMap.size() + 1);
            xAxis.setDrawGridLines(false);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的位置
            IAxisValueFormatter formatter = new IAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    for (int i = 0; i < xValue.size(); i++) {
                        if (value == i) {
                            return xValue.get(i);
                        }
                    }
                    return "";
                }
            };
            xAxis.setValueFormatter(formatter);
            xAxis.setEnabled(true);
            lineChart.setData(lineData);//装载数据
            lineChart.setScaleXEnabled(false);
            lineChart.getAxisRight().setEnabled(false);
            lineChart.setDescription(null);
            lineChart.animateX(1000);
            lineChart.animateY(1000);
            lineChart.invalidate();//刷新
        }
    }

    /**
     * 格式化得到的数据源
     */
    private Map<Long, Integer> formatValue(List<ProcedureNumModel> numModels) {
        //使用treeMap，使得Key值升序
        Map<Long, Integer> modelMap = new TreeMap<>();
        for (ProcedureNumModel model : numModels) {
            long timesTamp = TimeUtil.setStringToStamp(model.getCreatedAt(), TimeUtil.TIME_DEFAULT_MONTH);
            if (modelMap.get(timesTamp) != null) {
                modelMap.put(timesTamp, model.getSuccessCount() + modelMap.get(timesTamp));
            } else {
                modelMap.put(timesTamp, model.getSuccessCount());
            }
        }
        return modelMap;
    }

    /**
     * 加载数据成功时回调
     */
    public void onDataLoadedSuccess(ProcedureNumListResponse response) {
        disMissProgressDialog();
        List<ProcedureNumModel> list = response.getLogs();
        List<Integer> procedureModels = new ArrayList<>();
        //将title的内容加进去
        int count = list.size() * 6;
        for (int i = 0; i < 6 + count; i++) {
            procedureModels.add(-1);
        }
        adapter.setModels(list);
        adapter.setData(procedureModels);
        initChart(response);
    }


    public void onDataLoadedFailed() {
        disMissProgressDialog();
    }
}
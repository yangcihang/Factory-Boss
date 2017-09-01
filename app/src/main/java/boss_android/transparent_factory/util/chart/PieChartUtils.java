package boss_android.transparent_factory.util.chart;

import com.github.mikephil.charting.charts.PieChart;

/**
 * @author YangCihang
 * @since 17/8/26.
 * email yangcihang@hrsoft.net
 */

public class PieChartUtils {
    public static void initPieChart(PieChart pieChart) {
        pieChart.setEnabled(true);
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);
        pieChart.setDescription(null);
    }
}

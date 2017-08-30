package boss_android.transparent_factory.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.home.model.HomeChartModel;
import butterknife.BindView;
import butterknife.BindViews;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class HomeChartAdapter extends RecyclerFooterAdapter<HomeChartModel> {


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

    class ItemHolder extends ViewHolder<HomeChartModel> {
        @BindView(R.id.txt_home_order_create_time)
        TextView createTimeTxt;
        @BindView(R.id.txt_home_order_end_time)
        TextView endTimeTxt;
        @BindView(R.id.txt_home_order_title)
        TextView titleTxt;
        @BindView(R.id.txt_home_order_description)
        TextView descriptionTxt;
        @BindView(R.id.txt_home_order_id)
        TextView orderIdTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(HomeChartModel homeChartModel, int position) {

        }
    }
}

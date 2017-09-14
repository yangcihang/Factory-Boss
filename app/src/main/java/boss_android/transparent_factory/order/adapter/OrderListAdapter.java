package boss_android.transparent_factory.order.adapter;

import android.content.Context;
import android.icu.math.BigDecimal;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.order.model.OrderListModel;
import boss_android.transparent_factory.util.FloatUtil;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class OrderListAdapter extends RecyclerFooterAdapter<OrderListModel> {

    public OrderListAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_ITEM) {
            View view = inflater.inflate(R.layout.item_rec_order_list, parent, false);
            return new ItemHolder(view);
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }

    class ItemHolder extends ViewHolder<OrderListModel> {
        @BindView(R.id.txt_order_title)
        TextView titleTxt;
        @BindView(R.id.txt_order_custom)
        TextView customTxt;
        @BindView(R.id.txt_order_id)
        TextView orderIdTxt;
        @BindView(R.id.txt_order_capacity)
        TextView capacityTxt;
        @BindView(R.id.txt_order_create_time)
        TextView createTxt;
        @BindView(R.id.txt_order_end_time)
        TextView endTxt;
        @BindView(R.id.progress_order)
        ProgressBar orderProgress;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderListModel orderListModel, int position) {
            titleTxt.setText(orderListModel.getTitle());
            customTxt.setText(orderListModel.getCustomerInfo());
            orderIdTxt.setText("订单号" + String.valueOf(orderListModel.getOrderCode()));
            capacityTxt.setText(String.valueOf(FloatUtil.getFloat(orderListModel.getCapacity(), 2) * 100) + "%");
            createTxt.setText(orderListModel.getCreatedAt());
            endTxt.setText(orderListModel.getEndTime());
            orderProgress.setProgress((int) (orderListModel.getCapacity() * 100));
        }
    }
}

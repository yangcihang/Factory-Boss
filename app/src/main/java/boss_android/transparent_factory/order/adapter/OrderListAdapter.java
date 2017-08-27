package boss_android.transparent_factory.order.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.order.model.OrderListModel;

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
        return null;
    }
}

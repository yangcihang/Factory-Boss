package boss_android.transparent_factory.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.mine.model.EmployeeModel;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class EmployeeAdapter extends RecyclerFooterAdapter<EmployeeModel> {
    public EmployeeAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_ITEM) {
            return new ItemHolder(inflater.inflate(R.layout.item_rec_mine_employee, parent, false));
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    class ItemHolder extends ViewHolder<EmployeeModel> {
        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(EmployeeModel employeeModel, int position) {

        }
    }
}

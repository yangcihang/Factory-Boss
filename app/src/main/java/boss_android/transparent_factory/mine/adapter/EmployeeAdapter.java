package boss_android.transparent_factory.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.mine.model.EmployeeModel;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class EmployeeAdapter extends RecyclerViewAdapter<EmployeeModel> {
    public EmployeeAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder<EmployeeModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(inflater.inflate(R.layout.item_rec_mine_employee, parent, false));
    }

    class ItemHolder extends ViewHolder<EmployeeModel> {
        @BindView(R.id.txt_mine_employee_name)
        TextView nameTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(EmployeeModel employeeModel, int position) {
            nameTxt.setText(employeeModel.getName());
        }
    }
}

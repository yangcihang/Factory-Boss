package boss_android.transparent_factory.detail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.detail.model.ProcedureModel;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class DetailProcedureAdapter extends RecyclerViewAdapter<ProcedureModel> {
    public DetailProcedureAdapter(Context context) {
        super(context);
    }


    @Override
    public ViewHolder<ProcedureModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(inflater.inflate(R.layout.item_rec_order_detail_procedure, parent, false));
    }

    class ItemHolder extends ViewHolder<ProcedureModel> {
        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(ProcedureModel procedureModel, int position) {

        }
    }
}

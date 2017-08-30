package boss_android.transparent_factory.home.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerFooterAdapter;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.home.model.HomeDataModel;
import boss_android.transparent_factory.home.model.HomeDataProcedureModel;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/8/29.
 * email yangcihang@hrsoft.net
 */

public class HomeDataAdapter extends RecyclerFooterAdapter<HomeDataModel> {
    public HomeDataAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_ITEM) {
            View view = inflater.inflate(R.layout.item_rec_home_data, parent, false);
            return new ItemHolder(view);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    class ItemHolder extends ViewHolder<HomeDataModel> {
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
        @BindView(R.id.rec_home_data_procedure)
        RecyclerView procedureRec;
        private HomeDataProcedureAdapter adapter;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(HomeDataModel homeDataModel, int position) {
            adapter = new HomeDataProcedureAdapter(context);
            List<HomeDataProcedureModel> list = new ArrayList<>();
            list.add(new HomeDataProcedureModel());
            list.add(new HomeDataProcedureModel());
            list.add(new HomeDataProcedureModel());
            adapter.setData(list);
            procedureRec.setAdapter(adapter);
            procedureRec.setLayoutManager(new LinearLayoutManager(context));
        }

    }
}

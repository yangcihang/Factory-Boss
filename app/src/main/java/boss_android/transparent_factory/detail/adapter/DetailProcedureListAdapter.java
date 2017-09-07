package boss_android.transparent_factory.detail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.detail.model.ProcedureNumListResponse;
import boss_android.transparent_factory.detail.model.ProcedureNumModel;
import butterknife.BindView;

/**
 * @author YangCihang
 * @since 17/9/4.
 * email yangcihang@hrsoft.net
 */

public class DetailProcedureListAdapter extends RecyclerViewAdapter<Integer> {
    private List<String> titleName;//titleName；
    private List<ProcedureNumModel> models;

    public DetailProcedureListAdapter(Context context) {
        super(context);
        titleName = new ArrayList<>();
        titleName.add("时间");
        titleName.add("总件数");
        titleName.add("合格率");
        titleName.add("合格数");
        titleName.add("次品数");
        titleName.add("计件人");
    }

    /**
     * 设置数据模型
     */
    public void setModels(List<ProcedureNumModel> models) {
        this.models = models;
    }

    @Override
    public ViewHolder<Integer> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(inflater.inflate(R.layout.item_rec_detail_procedure_list, parent, false));
    }

    class ItemHolder extends ViewHolder<Integer> {
        @BindView(R.id.txt_detail_procedure_item)
        TextView procedureItemTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(Integer integer, int position) {
            ProcedureNumModel procedureNumModel = new ProcedureNumModel();
            int percent = 0;
            int failedCount = 0;
            if (position / 6 > 0) {
                procedureNumModel = models.get((position / 6) - 1);
                percent = (int) (((float) procedureNumModel.getSuccessCount() / (float) procedureNumModel.getTotalCount()) * 100);
                failedCount = procedureNumModel.getTotalCount() - procedureNumModel.getSuccessCount();
            }
            switch (position % 6) {
                case 0:
                    if (position == 0) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(procedureNumModel.getCreatedAt());
                    }
                    break;
                case 1:
                    if (position == 1) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(String.valueOf(procedureNumModel.getTotalCount()));
                    }
                    break;
                case 2:
                    if (position == 2) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(String.valueOf(percent) + "%");
                    }
                    break;
                case 3:
                    if (position == 3) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(String.valueOf(procedureNumModel.getSuccessCount()));
                    }
                    break;
                case 4:
                    if (position == 4) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(String.valueOf(failedCount));
                    }
                    break;
                case 5:
                    if (position == 5) {
                        procedureItemTxt.setText(titleName.get(position));
                    } else {
                        procedureItemTxt.setText(procedureNumModel.getLeaderName());
                    }
                    break;
            }

        }
    }
}

package boss_android.transparent_factory.detail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.detail.model.ProcedureModel;
import boss_android.transparent_factory.util.TimeUtil;
import butterknife.BindView;

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
        @BindView(R.id.txt_detail_procedure_class_title) TextView procedureClassTitleTxt;
        @BindView(R.id.txt_detail_procedure_id) TextView procedureIdTxt;
        @BindView(R.id.txt_detail_procedure_title) TextView procedureTitleTxt;
        @BindView(R.id.txt_detail_procedure_processing) TextView procedureProcessingTxt;
        @BindView(R.id.progress_detail_procedure) ProgressBar detailProcedureProgress;
        @BindView(R.id.txt_detail_procedure_create_time) TextView createTimeTxt;
        @BindView(R.id.txt_detail_procedure_end_time) TextView endTimeTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(ProcedureModel procedureModel, int position) {
            float successCount = procedureModel.getSuccessCount();
            float totalCount = procedureModel.getTotalCount();
            int progress = (int) ((successCount / totalCount) * 100);
            procedureIdTxt.setText(String.valueOf("任务号:" + procedureModel.getId()));
            procedureClassTitleTxt.setText(procedureModel.getWorkGroupName());
            procedureTitleTxt.setText(procedureModel.getName());
            procedureProcessingTxt.setText(String.valueOf((int) successCount) + "/" +
                    String.valueOf((int) totalCount));
            detailProcedureProgress.setProgress(progress);
            createTimeTxt.setText(TimeUtil.setStampToString(TimeUtil.setStringToStamp
                            (procedureModel.getCreatedAt(), TimeUtil.DATE_DEFAULT_FORMAT),
                    TimeUtil.DATE_DEFAULT_FORMAT));
            endTimeTxt.setText(TimeUtil.setStampToString(TimeUtil.setStringToStamp
                            (procedureModel.getEndTime(), TimeUtil.DATE_DEFAULT_FORMAT),
                    TimeUtil.DATE_DEFAULT_FORMAT));
        }
    }
}

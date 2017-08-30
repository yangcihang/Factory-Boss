package boss_android.transparent_factory.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.adapter.RecyclerViewAdapter;
import boss_android.transparent_factory.home.model.HomeDataProcedureModel;
import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * @author YangCihang
 * @since 17/8/30.
 * email yangcihang@hrsoft.net
 */

public class HomeDataProcedureAdapter extends RecyclerViewAdapter<HomeDataProcedureModel> {
    private List<Boolean> flagList; //标记展开的Layout,默认都为false
    private int oldPosition = -1; //标记以前的位置

    public HomeDataProcedureAdapter(Context context) {
        super(context);
        flagList = new ArrayList<>();
    }

    @Override
    public void setData(Collection<HomeDataProcedureModel> data) {
        super.setData(data);
        for (int i = 0; i < data.size(); i++) {
            flagList.add(false);
        }
        flagList.set(0, true);//默认第一个展开
        oldPosition = 0;
    }

    @Override
    public ViewHolder<HomeDataProcedureModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(inflater.inflate(R.layout.item_rec_home_data_procedure, parent, false));
    }

    /**
     * 设置点击事件
     */
    @Override
    public void onBindViewHolder(ViewHolder<HomeDataProcedureModel> holder, final int position) {
        super.onBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oldPosition != -1) {
                    flagList.set(oldPosition, !flagList.get(oldPosition));
                    refresh(oldPosition);
                }
                flagList.set(position, !flagList.get(position));
                refresh(position);
                oldPosition = position;
            }
        });
    }

    class ItemHolder extends ViewHolder<HomeDataProcedureModel> {
        @BindView(R.id.rl_home_order_data_menu)
        RelativeLayout menuLy;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(HomeDataProcedureModel homeDataProcedureModel, int position) {
            if (flagList.get(position)) {
                menuLy.setVisibility(VISIBLE);
            } else {
                menuLy.setVisibility(GONE);
            }
//            //每次都会调用下面的方法，这样的listener为最后一次所确定的，其中pos一直为最后一次的值
//            setOnItemClickedListener(new OnItemClicked<HomeDataProcedureModel>() {
//                @Override
//                public void onItemClicked(HomeDataProcedureModel homeDataProcedureModel, ViewHolder holder) {
//                    if (oldPosition != -1) {
//                        flagList.set(oldPosition, false);
//                    }
//                    oldPosition = pos;
//                    flagList.set(pos, true);
////                    refresh(position);
//                    notifyDataSetChanged();
//                }
//            });
        }
    }
}

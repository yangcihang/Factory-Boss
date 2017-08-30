package boss_android.transparent_factory.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import boss_android.transparent_factory.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

public abstract class RecyclerFooterAdapter<Data> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int FOOTER_ITEM = 1;
    public static final int DATA_ITEM = 0;
    private List<Data> dataList;
    protected Context context;
    protected LayoutInflater inflater;
    protected RefreshFooterHolder footerHolder;
    private OnItemClicked<Data> onItemClickedListener;

    public RecyclerFooterAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    /**
     * 设置数据
     *
     * @param data 数据
     */
    public void setData(Collection<Data> data) {
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 添加一条数据
     *
     * @param data 数据
     */
    public void add(Data data) {
        this.dataList.add(data);
        notifyDataSetChanged();
    }

    /**
     * 添加多条数据
     *
     * @param collection 数据
     */
    public void addAll(Collection<Data> collection) {
        this.dataList.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 移除数据
     *
     * @param data 移除的数据
     */
    public void remove(Data data) {
        this.dataList.remove(data);
        notifyDataSetChanged();
    }

    /**
     * 清空列表
     */
    public void clear() {
        this.dataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 刷新页面
     */
    public void refresh() {
        notifyDataSetChanged();
    }

    /**
     * 获取当前列表的数据
     */
    public List<Data> getListData() {
        return this.dataList;
    }


    /**
     * 获取position 处数据
     */
    public Data getItem(int position) {
        return dataList.get(position);
    }

    /**
     * 获取当前viewType（有底部刷新布局时）
     *
     * @param position pos
     * @return type
     */
    @Override
    public int getItemViewType(int position) {
        if (position < dataList.size()) {
            return DATA_ITEM;
        } else {
            return FOOTER_ITEM;
        }
    }

    /**
     * 绑定holder
     *
     * @param holder   holder
     * @param position position
     */

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position < dataList.size()) {
            Data data = dataList.get(position);
            ((ViewHolder<Data>) holder).bind(data, position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickedListener != null) {
                        onItemClickedListener.onItemClicked(dataList.get(position), (ViewHolder) holder);
                    }
                }
            });
        }
    }

    /**
     * 根据不同种类创建不同的holder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER_ITEM) {
            View view = inflater.inflate(R.layout.item_rec_footer, parent, false);
            footerHolder = new RefreshFooterHolder(view);
            return footerHolder;
        }
        return null;
    }

    /**
     * 获取总数量
     *
     * @return num
     */
    @Override
    public int getItemCount() {
        return dataList == null ? 1 : dataList.size() + 1;
    }


    /**
     * ContentViewHolder
     *
     * @param <Data>
     */
    public abstract static class ViewHolder<Data> extends RecyclerView.ViewHolder {
        private Data mData;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Data data, int position) {
            mData = data;
            onBind(data, position);
        }

        //绑定数据
        protected abstract void onBind(Data data, int position);
    }

    /**
     * 设置是否处于刷新状态
     */
    public void setToRefresh(boolean toRefresh) {
        if (toRefresh) {
            if (footerHolder != null) {
                footerHolder.footerProgress.setVisibility(View.VISIBLE);
                footerHolder.loadMoreTxt.setText("正在加载");
            }
        } else {
            footerHolder.footerProgress.setVisibility(GONE);
            footerHolder.loadMoreTxt.setText("已经加载完啦");
        }
    }

    /**
     * 底部刷新的holder
     */
    public class RefreshFooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progress_footer)
        ProgressBar footerProgress;
        @BindView(R.id.txt_load_more)
        TextView loadMoreTxt;

        RefreshFooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 设置点击事件监听
     */
    public void setOnItemClickedListener(OnItemClicked<Data> onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }


    /**
     * 点击事件接口
     */
    public interface OnItemClicked<Data> {
        void onItemClicked(Data data, ViewHolder holder);
    }


}

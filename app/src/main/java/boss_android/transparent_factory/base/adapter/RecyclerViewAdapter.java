package boss_android.transparent_factory.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author: Vzer.
 * @date: 2017/7/26. 17:46
 * @email: vzer@qq.com
 */

public abstract class RecyclerViewAdapter<Data> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder<Data>> {

    private List<Data> dataList;
    protected Context context;
    protected LayoutInflater inflater;
    private OnItemClicked<Data> onItemClickedListener;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        dataList = new ArrayList<Data>();
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

    public void refresh(int position) {
        notifyItemChanged(position);
    }

    /**
     * 获取当前列表的数据
     *
     * @return
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


    @Override
    public void onBindViewHolder(final ViewHolder<Data> holder, final int position) {
        //ViewHolder绑定数据
        Data data = dataList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClicked(dataList.get(position), holder);
                }
            }

        });
        holder.bind(data, position);
    }


    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
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
}

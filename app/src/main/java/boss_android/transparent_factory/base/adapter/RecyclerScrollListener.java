package boss_android.transparent_factory.base.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author YangCihang
 * @since 17/8/17.
 * email yangcihang@hrsoft.net
 */

public class RecyclerScrollListener extends RecyclerView.OnScrollListener {
    private OnScrolledToLast scrolledToLastListener;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        // 滑动停止
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            //获取最后一个完全显示的ItemPosition ,角标值
            int lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
            int totalItemCount = layoutManager.getItemCount();
            // 判断是否滚动到底部
            if (lastVisibleItem == (totalItemCount - 1)) {
                if (scrolledToLastListener != null) {
                    scrolledToLastListener.onScrolledToLast(lastVisibleItem);
                }
            }
        }
    }

    /**
     * 监听滑动到最后
     */
    public interface OnScrolledToLast {
        void onScrolledToLast(int position);
    }

    public void setScrolledToLastListener(OnScrolledToLast scrolledToLastListener) {
        this.scrolledToLastListener = scrolledToLastListener;
    }
}

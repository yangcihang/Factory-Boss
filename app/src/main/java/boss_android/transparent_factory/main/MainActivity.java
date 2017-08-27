package boss_android.transparent_factory.main;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import boss_android.transparent_factory.R;
import boss_android.transparent_factory.base.activity.NoBarActivity;
import boss_android.transparent_factory.home.HomeFragment;
import boss_android.transparent_factory.mine.MineFragment;
import boss_android.transparent_factory.order.OrderListFragment;
import boss_android.transparent_factory.util.FragmentUtil;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends NoBarActivity {

    @BindView(R.id.ll_tab_menu_home)
    LinearLayout homeLl;
    @BindView(R.id.ll_tab_menu_order_list)
    LinearLayout orderListLl;
    @BindView(R.id.ll_tab_menu_mine)
    LinearLayout mineLl;
    @BindView(R.id.txt_tab_menu_home)
    TextView homeTxt;
    @BindView(R.id.txt_tab_menu_mine)
    TextView mineTxt;
    @BindView(R.id.txt_tab_menu_order_list)
    TextView orderListTxt;
    @BindView(R.id.img_tab_menu_home)
    ImageView homeImg;
    @BindView(R.id.img_tab_menu_order_list)
    ImageView orderListImg;
    @BindView(R.id.img_tab_menu_mine)
    ImageView mineImg;
    private static final String HOME_TAG = "home";
    private static final String ORDER_TAG = "order";
    private static final String MINE_TAG = "mine";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    /**
     * 点击首页
     */
    @OnClick(R.id.ll_tab_menu_home)
    void onHomeMenuClicked() {
        changeHomeStatus();
        replaceFragment(R.id.ll_tab_menu_home);
    }

    /**
     * 点击订单列表
     */
    @OnClick(R.id.ll_tab_menu_order_list)
    void onOrderListClicked() {
        changeOrderListStatus();
        replaceFragment(R.id.ll_tab_menu_order_list);
    }

    /**
     * 点击我的
     */
    @OnClick(R.id.ll_tab_menu_mine)
    void onMineClicked() {
        changeMineStatus();
        replaceFragment(R.id.ll_tab_menu_mine);
    }

    /**
     * 展示当前的fragment
     */
    private void replaceFragment(int resId) {
        OrderListFragment orderListFragment = (OrderListFragment) getSupportFragmentManager().findFragmentByTag(ORDER_TAG);
        MineFragment mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag(MINE_TAG);
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOME_TAG);
        if (mineFragment != null) {
            FragmentUtil.hideFragment(this, mineFragment);
        }
        if (orderListFragment != null) {
            FragmentUtil.hideFragment(this, orderListFragment);
        }
        if (homeFragment != null) {
            FragmentUtil.hideFragment(this, homeFragment);
        }
        switch (resId) {
            case R.id.ll_tab_menu_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    FragmentUtil.add(this, R.id.fl_content, homeFragment, HOME_TAG);
                } else {
                    FragmentUtil.showFragment(this, homeFragment);
                }
                break;
            case R.id.ll_tab_menu_order_list:
                if (orderListFragment == null) {
                    orderListFragment = new OrderListFragment();
                    FragmentUtil.add(this, R.id.fl_content, orderListFragment, ORDER_TAG);
                } else {
                    FragmentUtil.showFragment(this, orderListFragment);
                }
                break;
            case R.id.ll_tab_menu_mine:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    FragmentUtil.add(this, R.id.fl_content, mineFragment, MINE_TAG);
                } else {
                    FragmentUtil.showFragment(this, mineFragment);
                }
                break;
            default:
                logicError();
                break;
        }
    }

    /**
     * 改变首页状态
     */
    private void changeHomeStatus() {
        clearAllStatus();
        homeTxt.setSelected(true);
        homeImg.setSelected(true);
    }

    /**
     * 改变订单列表状态
     */
    private void changeOrderListStatus() {
        clearAllStatus();
        orderListTxt.setSelected(true);
        orderListImg.setSelected(true);
    }

    /**
     * 改变我的页面状态
     */
    private void changeMineStatus() {
        clearAllStatus();
        mineImg.setSelected(true);
        mineTxt.setSelected(true);
    }

    /**
     * 清除所有状态
     */
    private void clearAllStatus() {
        homeTxt.setSelected(false);
        mineTxt.setSelected(false);
        orderListTxt.setSelected(false);
        homeImg.setSelected(false);
        mineImg.setSelected(false);
        orderListImg.setSelected(false);
    }
}


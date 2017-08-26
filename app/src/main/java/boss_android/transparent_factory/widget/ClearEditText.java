package boss_android.transparent_factory.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import boss_android.transparent_factory.R;

/**
 * @author: Vzer.
 * @date: 2017/7/30. 11:09
 * @email: vzer@qq.com
 */

@SuppressLint("AppCompatCustomView")
public class ClearEditText extends EditText implements TextWatcher, View.OnFocusChangeListener {
    private Drawable mDelete;//删除Icon
    private boolean hasFocus = false;//是否获得焦点

    public ClearEditText(Context context) {
        super(context);
        init();
    }


    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化
    private void init() {
        addDeleteView();
    }

    //初始化删除按钮 及删除事件
    private void addDeleteView() {
        mDelete = getResources().getDrawable(R.drawable.edit_clear);
        //添加文本变化监听 以及焦点变化的监听
        addTextChangedListener(this);
        setOnFocusChangeListener(this);
    }

    private void setDrawable() {
        //设置Icon位置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, mDelete, null);
        }
    }

    private void setDisable() {
        //清除Icon
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //对Icon点击的判断
        if (hasFocus && length() > 0 && event.getAction() == MotionEvent.ACTION_UP) {
            int evX = (int) event.getRawX();
            int evY = (int) event.getRawY();
            //构建Icon范围
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - mDelete.getIntrinsicHeight();
            //判断点击是否为Icon
            if (rect.contains(evX, evY)) {
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 文本变化的监听
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (TextUtils.isEmpty(s)) {
            setDisable();
        } else setDrawable();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * 焦点变化的监听
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        //焦点变化时 对Icon的处理
        if (hasFocus) {
            if (length() > 0) {
                setDrawable();
            } else setDisable();
        } else setDisable();
    }


}

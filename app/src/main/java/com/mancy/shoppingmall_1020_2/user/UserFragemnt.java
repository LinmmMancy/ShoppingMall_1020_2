package com.mancy.shoppingmall_1020_2.user;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.shoppingmall_1020_2.bean.BaseFragment;

/**
 * Created by Mancy on 2017/2/22.
 * <p>
 * <p>
 * 用户
 */


public class UserFragemnt extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);

        return textView;
    }

    @Override
    public void initData() {
        super.initData();

        Log.e("TAG", "我是用户");

        textView.setText("用户内容");
    }
}

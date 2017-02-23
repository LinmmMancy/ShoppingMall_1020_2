package com.mancy.shoppingmall_1020_2.CommunityFragment.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.shoppingmall_1020_2.bean.BaseFragment;

/**
 * Created by Mancy on 2017/2/22.
 * 
 * 
 * 发现
 */


public class CommunityFragment extends BaseFragment {
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

        Log.e("TAG", "我是发现");

        textView.setText("发现内容");
    }
}

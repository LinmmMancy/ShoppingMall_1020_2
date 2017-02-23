package com.mancy.shoppingmall_1020_2.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.mancy.shoppingmall_1020_2.R;
import com.mancy.shoppingmall_1020_2.bean.BaseFragment;
import com.mancy.shoppingmall_1020_2.bean.HomeBean;
import com.mancy.shoppingmall_1020_2.home.fragment.adapter.HomeAdapter;
import com.mancy.shoppingmall_1020_2.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by Mancy on 2017/2/22.
 */

public class HomeFragment extends BaseFragment {


    @InjectView(R.id.ll_main_scan)
    LinearLayout llMainScan;
    @InjectView(R.id.tv_search_home)
    TextView tvSearchHome;
    @InjectView(R.id.tv_message_home)
    TextView tvMessageHome;
    @InjectView(R.id.rv_home)
    android.support.v7.widget.RecyclerView rvHome;
    @InjectView(R.id.ib_top)
    ImageButton ibTop;

    private HomeAdapter adapter;

    @Override
    public View initView() {


        View view = View.inflate(context, R.layout.fragment_home, null);

        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();

        getDataFromNet();


        Log.e("TAG", "我是主页");


    }

    private void getDataFromNet() {

        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError: 联网失败" + e.getMessage());

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Log.e("TAG", "onResponse: 联网成功");

                        processData(response);


                    }


                });


    }


    /**
     * 1.三种解析方式：fastjson解析数据和Gson和手动解析
     * 2.设置适配器
     *
     * @param
     */

    private void processData(String response) {
        //使用fastjson解析json数据
        HomeBean homeBean = JSON.parseObject(response, HomeBean.class);
        Log.e("TAG", "解析数据成功==" + homeBean.getResult().getHot_info().get(0).getName());

        //设置RecyclerView的适配器

        adapter = new HomeAdapter(context, homeBean.getResult());
        rvHome.setAdapter(adapter);

        //设置布局管理器
        rvHome.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_search_home, R.id.tv_message_home, R.id.ib_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search_home:
                Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_message_home:
                Toast.makeText(context, "查看消息", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_top:
                Toast.makeText(context, "回到顶部", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
